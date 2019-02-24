package es.cem.utilidades;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Mqtt {

	public static void publish(String urlActivador, String valor, String topic) throws MqttException{
		MqttClient client = new MqttClient("tcp://"+urlActivador+":1883", MqttClient.generateClientId());
		client.connect();
		MqttMessage message = new MqttMessage();
		message.setPayload(valor.getBytes());
		client.publish(topic, message);
		client.disconnect();
	}
	
}
