package Test;

import Service.Operation;

public class testBianJi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operation operation = new Operation();
		String result;
		result = operation.sendGet("https://www.zhihu.com", "utf-8");
		String src = operation.RegexString(result, "question_link.+?>(.+?)<");
		System.out.println(result);
	}

}
