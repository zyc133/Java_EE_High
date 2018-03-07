package multi.multi6.lock020;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * ReentrantLock等待可中断、可实现公平锁、以及锁可以绑定多个条件。
 * ReentrantLock和synchronized关键字的区别
    ReentrantLock在等待锁时可以使用lockInterruptibly()方法选择中断， 改为处理其他事情，而synchronized关键字，线程需要一直等待下去。同样的，tryLock()方法可以设置超时时间，用于在超时时间内一直获取不到锁时进行中断。
    ReentrantLock可以实现公平锁，而synchronized的锁是非公平的。
    ReentrantLock拥有方便的方法用于获取正在等待锁的线程。
    ReentrantLock可以同时绑定多个Condition对象，而synchronized中，锁对象的wait()和notify()或notifyAll()方法可以实现一个隐含的条件，如果要和多于一个条件关联时，只能再加一个额外的锁，而ReentrantLock只需要多次调用newCondition方法即可。

 * @Description: TODO
 * @author: zhangyc
 * @date: 2018年3月6日 下午5:43:25
 */
public class UseReentrantLock {
	
	private Lock lock = new ReentrantLock();
	
	public void method1(){
		try {
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method1..");
			Thread.sleep(1000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method1..");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			
			lock.unlock();
		}
	}
	
	public void method2(){
		try {
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method2..");
			Thread.sleep(2000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method2..");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {

		final UseReentrantLock ur = new UseReentrantLock();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				ur.method1();
				ur.method2();
			}
		}, "t1");

		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println(ur.lock.getQueueLength());
	}
	
	
}
