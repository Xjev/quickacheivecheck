package com.wowapi.model;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class MyHttpUtil {
	
	private static Logger logger = Logger.getLogger(MyHttpUtil.class);
	
	public String get (String url) {
		return get(url, new ArrayList<Pair<String, String>>());
	}
	
	public String get (String url, List<Pair<String, String>> headers) {
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
	 
		// add request headers
		for (Pair<String, String> pair: headers) {
			request.addHeader(pair.getKey(), pair.getValue());
		}
		
		HttpResponse response;		
		String responseString = null;
		try {
			response = client.execute(request);
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}	
			
		return responseString;
	}
}
