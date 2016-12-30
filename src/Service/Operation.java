package Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {
	public String sendGet(String url, String charset){
		String result = "";
		BufferedReader in = null;
//		String charset="gb2312";
		try{
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.connect();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),charset));
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
		return result;
	}
	public String  RegexString(String result, String regex){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(result);
		if (matcher.find()){
			return matcher.group(0);
		}
		return null;
	}
}
