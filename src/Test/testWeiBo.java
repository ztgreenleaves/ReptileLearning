package Test;

import Service.HttpGetUtils;

public class testWeiBo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = HttpGetUtils.get("http://weibo.com/p/1004063623353053?is_all=1");
		System.out.println(result);
	}

}
