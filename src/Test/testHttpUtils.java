package Test;

import java.util.List;

import ImgBuilder.CreateImage;
import Service.HttpGetUtils;

public class testHttpUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String result = HttpGetUtils.get("http://weibo.com");
		  System.out.println(result);
		// List<String> list = HttpGetUtils.getImg(result);
		// System.out.println(list.size());
		// for (String l : list){
		// System.out.println(l.toString());
		// }
		// System.out.println(list.get(0).toString());
//		boolean flag = CreateImage.createFolder("E:/pic");
//		CreateImage.createImg("https://ws4.sinaimg.cn/mw600/661eb95cgw1fap4lm0r3yj20hm0qfn08.jpg");
	}

}
