package es.cem.ln;

import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.google.gson.Gson;

import es.cem.VO.ActivadoresVO;
import es.cem.ad.AdActivadores;
import es.cem.utilidades.Constantes;
import es.cem.utilidades.Mqtt;
import es.cem.utilidades.TratamientoDeDatos;

public class LnActivadores {
	
	public static String getActivadoresByUsuario(String idUsuario) throws SQLException{
		
		String[][] activadores = AdActivadores.getActivadoresByUsuario(idUsuario);
		
		final Gson gson = new Gson();
		ArrayList<ActivadoresVO> listaActivadores= getInfoBDList(activadores);
 		String activadoresJSON = gson.toJson(listaActivadores);
		return activadoresJSON;
	}
	
	
	public static String updateEstadoActivador(String idActivador, String estado) throws SQLException{
		
		//Conexion con mqtt
		try {
			String urlActivador = AdActivadores.getIpActivadorById(idActivador)[0];
			Mqtt.publish(urlActivador, estado, Constantes.TOPIC_ACTIVADOR);
			AdActivadores.updateEstadoActivador(idActivador, estado);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		
		return "1";
	}
	
	
	/**
	 * 
	 * @param activadores
	 * @return
	 */
	public static ArrayList<ActivadoresVO> getInfoBDList(String[][] activadores){
		
		ArrayList<ActivadoresVO> listaActivadores = new ArrayList<ActivadoresVO>();
		if(!TratamientoDeDatos.esNullCeroVacio(activadores)){
			for(int i = 0; i<activadores.length; i++){
				ActivadoresVO activadoresVO = new ActivadoresVO(activadores[i][0], activadores[i][1], activadores[i][2],activadores[i][3]);
				listaActivadores.add(activadoresVO);
			}
		}
		return listaActivadores;
	}

}
