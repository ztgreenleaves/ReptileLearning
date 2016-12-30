package Test;

public class testThreadC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		System.out.println(start);
		Thread1 T1 = new Thread1(start);
		new Thread(T1,"t1").start();
		new Thread(T1,"t2").start();
		new Thread(T1,"t3").start();
//		int i = 0;
//		testVisit tV = new testVisit();
//		while (i < 10){
//			tV.visitPage(tV.getCount());
//			int imgI = 0;
//			while (imgI < 5){
//				tV.createImg(tV.getCount(), "A" + imgI);
//				imgI++;
//			}
//			i++;
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("总共耗时" + (end - start) / 1000 + "秒");
		
	}


}
class Thread1 implements Runnable{
	testVisit tV = new testVisit();
	Thread1(long start) {
		// TODO Auto-generated constructor stub
		tV.setStart(start);
	}
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			synchronized(this){
				if (tV.getCount() < 10){
					System.out.println("Thread:" + Thread.currentThread().getName() + "-->");
					tV.visitPage(tV.getCount());
					tV.ImgUrl(tV.getCount());
					tV.setCount(tV.getCount()+1);
					
				}
				else
					break;
			}
		}
	}
}

