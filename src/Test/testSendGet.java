package Test;

import Service.Operation;

public class testSendGet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operation op = new Operation();
		String re = op.sendGet("http://www.baidu.com", "UTF-8");
		System.out.println(re);
	}

}
