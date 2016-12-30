package Test;

import java.util.List;

import ImgBuilder.CreateImage;
import Service.HttpGetUtils;

public class testJianDan {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pageNum = 2269;
		while (pageNum >= 100){
			System.out.println("----第" + pageNum + "页----");
			String url = "http://jandan.net/ooxx/page-" + pageNum + "#comments";
			String htmlContent = HttpGetUtils.get(url);
			List<String> urlList = HttpGetUtils.getImg(htmlContent);
			CreateImage.createFolder("e:/JianDan");
			int i = 0;
			while (i < urlList.size()) {
				CreateImage.createImg(urlList.get(i).toString());
				// System.out.println(urlList.get(i).toString());
				i++;
			}
			pageNum--;
		}
		System.out.println("Mission complete!");
	}
}
