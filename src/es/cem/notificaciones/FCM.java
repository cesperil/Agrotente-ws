package es.cem.notificaciones;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;

import org.json.JSONException;

import org.json.JSONObject;







public class FCM {



final static private String FCM_URL = "https://fcm.googleapis.com/fcm/send";
public final static String TOKEN_APP = "eLu6HtqENOc:APA91bFy6ms7-tIQTeCpT0jynMBwnCYJn0a4EoZroD-GzJ_wRvylEg1-pPgHNu9GL8_1PcSvstB-GzSUOiTZD7tk7wnwye5aPFat9F0XyedWvGggAza_aw_o19ekKl30GUFLQfNfuCVq";
//public final static String TOKEN_APP = "fQDZxRKfexI:APA91bEEtFFo80TNrEBPcUlMRmz0gRiJYQsDIbxzGpFyG039OEW3LTFnAA116ixia0miEMDUBfRnA4uNXEX5dU8X9HluIMynyKFDNiGSI4bHaqGfXq3Di4pj50-Qp4eZD2M5siXKbo5Y";

public final static String SERVER_APY_KEY = "AAAA830aMmk:APA91bGZ20S7OvWlX-1G5X9YT8vqLMXMibE8ooS88ScxtHfUJLzFDFVxs5mRzryn6tVQOJLco3chJqWxyPQObP9lrHV9HwC0tVpxXaTWxpgZsjL6NLsxeEurpS298CYO_3OZPlRnlfri";
//public final static String SERVER_APY_KEY = "AAAAAxqV4sY:APA91bGy981t0egFewUAN4DLM66TeExb-GzNWrW-zTJZ0uiYtgTwqaPPffaL_BONsHnJqjmLjMS0Tf6o6KtvHo9epET6TaOcAVq4ZagEYsgWwWuSOGfxLqXNk24ZsdYORXah3pC6eBzU";

/**

* 

* Method to send push notification to Android FireBased Cloud messaging Server.

* 

* @param tokenId Generated and provided from Android Client Developer

* @param server_key Key which is Generated in FCM Server 

* @param message which contains actual information.

* 

*/

public static void send_FCM_Notification(String tokenId, String server_key, String asunto,  String message){



try{

// Create URL instance.

URL url = new URL(FCM_URL);



// create connection.

HttpURLConnection conn;

conn = (HttpURLConnection) url.openConnection();



conn.setUseCaches(false);

conn.setDoInput(true);

conn.setDoOutput(true);



//set method as POST or GET

conn.setRequestMethod("POST");



//pass FCM server key

conn.setRequestProperty("Authorization","key="+server_key);



//Specify Message Format

conn.setRequestProperty("Content-Type","application/json");



//Create JSON Object & pass value

JSONObject infoJson = new JSONObject();

infoJson.put("title", asunto);

infoJson.put("body", message);



JSONObject json = new JSONObject();

json.put("to",tokenId.trim());

json.put("notification", infoJson);



OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

wr.write(json.toString());

wr.flush();

int status = 0;

if( null != conn ){

status = conn.getResponseCode();

}

if( status != 0){



if( status == 200 ){

//SUCCESS message

BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

System.out.println("Android Notification Response : " + reader.readLine());

}else if(status == 401){

//client side error

System.out.println("Notification Response : TokenId : " + tokenId + " Error occurred :");

}else if(status == 501){

//server side error

System.out.println("Notification Response : [ errorCode=ServerError ] TokenId : " + tokenId);

}else if( status == 503){

//server side error

System.out.println("Notification Response : FCM Service is Unavailable  TokenId : " + tokenId);

}



}

}catch(MalformedURLException mlfexception){

// Prototcal Error

System.out.println("Error occurred while sending push Notification!.." + mlfexception.getMessage());

}catch(IOException mlfexception){

//URL problem

System.out.println("Reading URL, Error occurred while sending push Notification!.." + mlfexception.getMessage());

}catch(JSONException jsonexception){

//Message format error

System.out.println("Message Format, Error occurred while sending push Notification!.." + jsonexception.getMessage());

}catch (Exception exception) {

//General Error or exception.

System.out.println("Error occurred while sending push Notification!.." + exception.getMessage());

}

}

}