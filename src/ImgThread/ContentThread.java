package ImgThread;

import java.util.List;

import ImgBuilder.CreateImage;
import Service.HttpGetUtils;

public class ContentThread implements Runnable {
	static int pageNum = 2276;
	
	public void run() {
		// TODO Auto-generated method stub
		CreateImage.createFolder("e:/JianDan");
		while (pageNum >= 100) {
			synchronized (this) {
				if (pageNum < 100)
					break;
				System.out.println("----第" + pageNum + "页----");
				String url = "http://jandan.net/ooxx/page-" + pageNum
						+ "#comments";
				String htmlContent = HttpGetUtils.get(url);
				HttpGetUtils.getImg(htmlContent);
				pageNum--;

			}

		}
	}

}
