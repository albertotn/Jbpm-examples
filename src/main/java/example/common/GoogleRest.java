package example.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class GoogleRest {

	public String get() {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet("http://www.google.it");
			HttpResponse response = client.execute(request);
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			String result = "";
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
