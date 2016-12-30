package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class testBaidu {
	public static void main(String args[]){
		String url = "http://www.baidu.com";
		String result = "";
		BufferedReader in = null;
//		String charset="gb2312";
		try{
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.connect();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null){
				result += line;
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				if (in != null){
					in.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		System.out.println(result);
//		System.out.println("haha");
	}
}
