package es.cem.notificaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Service {

	public static String HttpUrlConnection 	= "http://fcm.googleapis.com/fcm/send";
	public static String SERVER_API_KEY	  	= "AAAAAxqV4sY:APA91bGy981t0egFewUAN4DLM66TeExb-GzNWrW-zTJZ0uiYtgTwqaPPffaL_BONsHnJqjmLjMS0Tf6o6KtvHo9epET6TaOcAVq4ZagEYsgWwWuSOGfxLqXNk24ZsdYORXah3pC6eBzU";
	
	/**
	 * 
	 * @param deviceToken
	 * @param data
	 * @return
	 */
	private boolean sendRequest(String deviceToken, String data){
		
		boolean result = executePost(HttpUrlConnection, SERVER_API_KEY, deviceToken, data);
		
		return result;
	}
	
	
	public static boolean executePost(String targetURL, String serverKey, String deviceToken, String data){
		
		HttpURLConnection connection = null;
		
		try {
			URL url = new URL(targetURL);
			
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", "key="+serverKey);
			
			String timestamp =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			
			String postData  = " \"{\"collapse_key\":\"score_update\",\"time_to_live\":108,\"delay_while_idle\":true,\"data\": { \"message\" : \"\" + data + \"\",\"time\": \" + \"\"\" + timeStamp + \"\"},\"registration_ids\":[\"\" + deviceToken + \"\"]}\"";
			
			byte[] byteArray = postData.getBytes("UTF-8");
			
			connection.setRequestProperty("Content-Length", Integer.toString(byteArray.length));
			
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			
			OutputStream os = connection.getOutputStream();
			os.write(postData.getBytes("UTF-8"));
			os.flush();
			os.close();
			
			
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer response	= new StringBuffer();
			String line;
			while((line = rd.readLine()) != null){
				response.append(line);
			}
			rd.close();
			return true;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null){
				connection.disconnect();
			}
		}
		return false;
	}
	
}
