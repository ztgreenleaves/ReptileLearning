package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import ImgThread.ImgThread;

public class HttpGetUtils {
	public static String get(String url) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		// httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
		// httpGet.addHeader("Cookie","_gat=1; nsfw-click-load=off; gif-click-load=on; _ga=GA1.2.1861846600.1423061484");
		String result = null;
		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
			if (response != null
					&& response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				result = readResponse(entity, "utf-8");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static String readResponse(HttpEntity entity, String charset) {
		StringBuffer res = new StringBuffer();
		BufferedReader reader = null;
		try {
			if (entity == null) {
				return null;
			}
			reader = new BufferedReader(new InputStreamReader(
					entity.getContent(), charset));
			String line = null;
			while ((line = reader.readLine()) != null) {
				res.append(line + "\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return res.toString();
	}

	public static List<String> getImg(String result) {
		List<String> list = new ArrayList<String>();
		String regex = "</a><br /><img.+?src=\"(.+?)\"";// jiandan
		// String regex = "<img.+?src=//(.+?.png|.jpg|.gif)";//baidu
		// String str = "\.";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(result);
		int i = 1;
		while (matcher.find()) {
			String gifUrl = matcher.group(1);
			if (gifUrl.lastIndexOf("gif") == -1)
				list.add(gifUrl);
		}
		String regexGif = "</a><br /><img.+?org_src=\"(.+?)\"";
		pattern = Pattern.compile(regexGif);
		matcher = pattern.matcher(result);
		while (matcher.find()) {
			list.add(matcher.group(1));
		}
		System.out.println("list's size is " + list.size());
		ImgThread imgThread = new ImgThread(list);
		new Thread(imgThread, "img1").start();
		new Thread(imgThread, "img2").start();
		new Thread(imgThread, "img3").start();
		return list;
	}
}
