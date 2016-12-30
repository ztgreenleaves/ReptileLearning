package Test;

import ImgThread.ContentThread;

public class testThreadJianDan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContentThread thread = new ContentThread();
		new Thread(thread, "thread1").start();
		new Thread(thread, "thread2").start();
		new Thread(thread, "thread3").start();
	}

}
