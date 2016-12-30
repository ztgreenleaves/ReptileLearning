package Test;

import java.util.List;

import Service.HttpGetUtils;

public class testGif1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = HttpGetUtils.get("http://jandan.net/ooxx/page-2276#comments");
		List<String> list = HttpGetUtils.getImg(result);
		for (String l: list){
			System.out.println(l);
		}
		
	}

}
