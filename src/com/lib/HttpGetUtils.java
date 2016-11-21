package com.lib;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpGetUtils {
	public String get(String url){
		String result = "";
		try{
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);
			CloseableHttpResponse response = httpclient.execute(httpget);
			try{
				if (response != null && response.getStatusLine().getStatusCode()
						== HttpStatus.SC_OK ){
					System.out.println(response.getStatusLine());
					HttpEntity entity = response.getEntity();
					
//					System.out.println(EntityUtils.toString(entity, "UTF-8"));
					result = readResponse(entity, "UTF-8");
				}
			}
			finally{
				httpclient.close();
				response.close();
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public String readResponse(HttpEntity entity, String charset){
		StringBuffer res = new StringBuffer();
		BufferedReader reader = null;
		try{
			if (entity == null){
				return null;
			}
			else{
				reader = new BufferedReader(new InputStreamReader(entity.getContent(),charset));
				String line;
				while ( (line = reader.readLine()) != null){
					line = line + "\n";
					res.append(line);
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try{
				if (reader != null){
					reader.close();
				}
				
			}
			catch(Exception e){
				e.toString();
			}
		}
		return res.toString();
	}
	
	
}
