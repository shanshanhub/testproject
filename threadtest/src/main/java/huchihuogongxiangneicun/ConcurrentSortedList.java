package huchihuogongxiangneicun;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WanChuanLai
 * @create 8/28/16.
 * 插入新的链表时,需要将待插入位置两表的节点加锁.
 *
 * 首先锁住链表的前两个节点.如果这个两个节点之间不是待插入位置,那么就解锁第一个节点,并锁住第三个节点,
 * 如果被锁住的两个之间任然不是待插入位置,就解锁第二个节点,并锁住第四个节点.
 * 以此类推,直到找到插入位置并插入新的节点
 * 最终解锁两边的节点
 *
 *
 * 这种操作可以让多个线程并发的进行链表插入操作,
 * 还能让其他的链表操作安全的并发,比如计算链表的节点个数,值需要道墟遍历链表即可
 */

public class ConcurrentSortedList {
    private class Node{
        int value;
        Node prev;
        Node next;
        ReentrantLock lock=new ReentrantLock();
        Node()
        {}
        Node(int value,Node prev,Node next){
            this.value=value;
            this.prev=prev;
            this.next=next;
        }
    }
    private final Node head;
    private final Node tail;
    public ConcurrentSortedList(){
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
    }
    public void insert(int value){
        Node current=head;
        //1,锁住了头节点
        current.lock.lock();
        //2,锁住了下一个节点
        Node next=current.next;
        try{
            while (true){
                next.lock.lock();
                try{
                    //3,遍历链表直到找到第一个值小于新插入值得节点位置
                    //检查两个节点之间是否是待插入位置,如果不是
                    //5,如果找到了待插入位置,则,构造新的节点,将其插入到链表中返回.
                    if(next==tail||next.value<value){
                        Node node=new Node(value,current,next);
                        next.prev=node;
                        current.next=node;
                        return;
                    }
                }finally {
                    //4,如果上不是待插入位置,解锁当前节点继续遍历.
                    current.lock.unlock();
                }
                current=next;
                next=current.next;
            }

        }finally {
            next.lock.unlock();
        }
    }

    public int size(){
        Node current=tail;
        int count=0;
        while (current.prev!=head){
            ReentrantLock lock=current.lock;
            lock.lock();
            try {
                ++count;
            }finally {
                lock.unlock();
            }
        }
        return count;
    }
}
