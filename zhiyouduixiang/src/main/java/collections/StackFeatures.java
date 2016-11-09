package collections;

import java.util.Stack;

/**
 * @author WanChuanLai
 * @create 6/22/16.
 * 作用:"栈"通常是指"后进先出(LIFO)"的容器,有时栈也被称为 叠加栈,因此最后"压入"栈的元素,第一个"弹出"栈.
 * 1,LinkedList具有能够直接实现栈的所有功能的方法,因此可以把LinkedList做为栈使用,不过有时一个真正的栈更能把事情讲清楚.
 * 2,
 */
public class StackFeatures {
    public static void main(String [] args){
        Stack<Integer> integerStack=new Stack<Integer>();
        integerStack.add(10);
        integerStack.add(1);
        System.out.println(integerStack.peek());//后进先出,不删除出的元素
        System.out.println(integerStack);

        integerStack.add(2);
        System.out.println(integerStack.pop());//后进先出,删除出的元素
        System.out.println(integerStack);

        integerStack.push(3);
        System.out.println(integerStack.peek());
        System.out.println(integerStack);

    }
}
