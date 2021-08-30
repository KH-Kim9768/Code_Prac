package kr.ac.shingu.cs.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.nate.com");
			URLConnection urlConnection = url.openConnection();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			
			String line;
			
			while((line = br.readLine()) != null) {
				
				if(line.contains("a href")) {
					System.out.println(line);
				}
			}
			
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
