package ImgThread;

import java.util.List;

import ImgBuilder.CreateImage;

public class ImgThread implements Runnable {
	int i = 0;
	List<String> urlList;
	public ImgThread(List<String> list) {
		// TODO Auto-generated constructor stub
		this.urlList = list;
	}

	public void run() {
		// TODO Auto-generated method stub
		while (i < urlList.size()) {
			synchronized (this) {
				if (i == urlList.size())
					break;
				CreateImage.createImg(urlList.get(i).toString());
				// System.out.println(urlList.get(i).toString());
				i++;
			}
		}
	}
}
