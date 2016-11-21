package Test;

import com.lib.HttpGetUtils;

public class testRes {
	public static void main(String args[]){
		HttpGetUtils gu = new HttpGetUtils();
		String str = gu.get("https://zhidao.baidu.com/question/384147987.html");
		System.out.println(str);
	}
}
