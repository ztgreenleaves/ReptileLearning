package Test;

import java.util.List;

import ImgBuilder.CreateImage;
import Service.HttpGetUtils;

public class testTuiKu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://jandan.net/ooxx/page-2268#comments";
		String htmlContent = HttpGetUtils.get(url);
//		System.out.println(htmlContent);
		List<String> urlList = HttpGetUtils.getImg(htmlContent);
		CreateImage.createFolder("e:/TuiKu");
		int i = 0;
		while (i<urlList.size()){
			CreateImage.createImg(urlList.get(i).toString());
//			System.out.println(urlList.get(i).toString());
			i++;
		}
		System.out.println("Mission complete!");
	}

}
