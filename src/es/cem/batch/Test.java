package es.cem.batch;

import java.sql.SQLException;

import org.eclipse.paho.client.mqttv3.MqttException;

import es.cem.notificaciones.FCM;
import es.cem.utilidades.Constantes;
import es.cem.utilidades.Mqtt;

public class Test {
	
	public static void main(String[] args) {
		
		System.out.println("Prueba Notificaciones Push");
		
		FCM.send_FCM_Notification(FCM.TOKEN_APP, FCM.SERVER_APY_KEY, "Mensaje",  "mi novio no me quiere");
		
		 
	}

}
