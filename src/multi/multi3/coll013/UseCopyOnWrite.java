package multi.multi3.coll013;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UseCopyOnWrite {
	/**
	 * CopyOnWrite适合使用在读操作远远大于写操作的场景里，比如缓存。
	 * 读写锁-先复制一份数据，对数据的复制部分进行写操作。从原来的数据进行读操作
	 * 
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		
		CopyOnWriteArrayList<String> cwal = new CopyOnWriteArrayList<String>();
		CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<String>();
		
		
	}
}
