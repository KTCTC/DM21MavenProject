package brockenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.testng.annotations.Test;

public class BrockenLinkClass {

	@Test
	public void verifyURLIsBrockenOrNot() throws IOException
	{
		String link = "https://demoqa.com/links";
		
		URL url = new URL(link);
		URLConnection urlConn = url.openConnection();
		HttpURLConnection http = (HttpURLConnection)urlConn;
		
		http.setConnectTimeout(15000);
		
		http.connect();
		
		int resCode = http.getResponseCode();
		
		String resMsg = http.getResponseMessage();
		
		System.out.println(resCode);
		System.out.println(resMsg);
		
	}
}
