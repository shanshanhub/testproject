### 互斥和内存模型
java的基本单元是线程,可以将线程看作为控制流.线程之间通过共享内存来进行通讯.
yield:表示当前线程想让出对处理器的占用
join:当前线程 等待其它线程返回结果

#### 第一把锁
多个线程同时使用共享内存时,它们往往会 打成一片,为避免如此,我们可以使用锁达到线程互斥的目的.
即某一时间至少有一个线程能持有锁

java 中每个对象都有一把内置锁 
可以使用synchronized关键字获取对象上的锁
synchronized 不好处:
一个线程因为内置锁而进去堵塞后,讲无法中断该线程了
尝试获取内置锁时,无法设置超时.

与synchronized 不同,ReentrantLock提供了显示的lock 和unlock方法.



#### 内存可见性
java内存模型定义了何时一个线程对内存的修改对另外一个线程可见.
基本的原则是:如果读线程和写线程不进行同步,就不能保证可见性

#### 超越内置锁
ReentrantLock
java 中每个对象都有一把内置锁 
可以使用synchronized关键字获取对象上的锁
synchronized 不好处:
一个线程因为内置锁而进去堵塞后,讲无法中断该线程了
尝试获取内置锁时,无法设置超时.

与synchronized 不同,ReentrantLock提供了显示的lock 和unlock方法.

#### 超时锁
ReentrantLock 可以为获取锁的操作设置超时时间
详情看Philosopher.java

#### 交替锁
ReentrantLock
设想我没要在链表中插入一个节点,一种做法是用锁保护整个链表,但链表加锁时其它使用者无法访问链表
而交替锁可以只锁住链表的一部分,允许不涉及被锁部分的其他线程自由访问链表
详情看ConcurrentSortedList

#### 条件变量
并发编程通常需要等待某个事情发生.比如队列删除元素前需要等待队列非空/向缓存添加数据前需要等待缓存有足够的空间.
条件变量就是为这种情况设计的.
想起看ConditionVariable.java
详情看Philosopher.java

### 一个完整的程序
一个简单的串行统计程序
