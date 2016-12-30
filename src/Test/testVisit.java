package Test;

public class testVisit {
	static int count = 0;
	String[] str = { "A", "B", "C", "D", "E" };
	static int numCount = 0;
	static long start;

	public static void setCount(int count) {
		testVisit.count = count;
	}

	public static int getCount() {
		return count;
	}

	public void resetCount() {
		count = 0;
	}

	public void visitPage(int count) {
		try {
			new Thread().sleep(200);
			System.out.println("Page " + count + "is visited!");
			// get imgUrl List and run img function
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createImg(int count, String imgName) {
		int imgNum = 0;
		try {
			new Thread().sleep(100);
			System.out.println("=Page " + count + ": " + imgNum++ + "=="
					+ imgName + " image!");
			numCount++;
			if (numCount == 50){
				long end = System.currentTimeMillis();
				long sum = (end - start)/1000;
				System.out.println("start : " + start + "end : " + end);
				System.out.println("sum time is " + sum);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ImgUrl(int count) {
		int index = 0;
		ThreadImage1 imgT = new ThreadImage1(count, str);
		new Thread(imgT, "T1").start();
		new Thread(imgT, "T2").start();
		new Thread(imgT, "T3").start();
	}

	public void setStart(long start) {
		// TODO Auto-generated method stub
		this.start = start;
	}
}

class ThreadImage1 implements Runnable {
	String[] str;
	int index = 0;
	int count;
	testVisit visit = new testVisit();

	public ThreadImage1(int count, String[] str) {
		// TODO Auto-generated constructor stub
		this.count = count;
		this.str = str;
	}

	public void run() {
		// TODO Auto-generated method stub
		while (index < 5) {
			
			synchronized (this) {
				if (index == 5)
					break;
				visit.createImg(count, str[index]);
				index++;
			}
		}
	}
}
