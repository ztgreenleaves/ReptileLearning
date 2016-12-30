package Test;

import Service.Operation;

public class testRegex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operation operation = new Operation();
		String result;
		result = operation.sendGet("http://www.baidu.com", "utf-8");
		String src = operation.RegexString(result, "src=(.*?)(.png|.jpg)");
		System.out.println(src);
	}

}
