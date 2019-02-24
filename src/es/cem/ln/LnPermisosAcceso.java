package es.cem.ln;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.google.gson.Gson;

import es.cem.VO.MedicionesVO;
import es.cem.VO.ParcelasVO;
import es.cem.VO.SolicitudAccesoVO;
import es.cem.ad.AdActivadores;
import es.cem.ad.AdMedicionSensor;
import es.cem.ad.AdParcelas;
import es.cem.ad.AdPermisosAcceso;
import es.cem.utilidades.Constantes;
import es.cem.utilidades.Mqtt;

public class LnPermisosAcceso {
	
	public static int ESTADO_PTE_RESPUESTA = 0;
	public static int ESTADO_CONCEDIDO 	   = 1;
	public static int ESTADO_DENEGADA      = 2;
	
	/**
	 * 
	 * @param estado
	 * @return
	 * @throws SQLException
	 */
	public static String[][] getPermisosAccesoBatch(int estado) throws SQLException{
		return AdPermisosAcceso.getPermisosByEstado(estado);
	}
	
	/**
	 * 
	 * @param idUsuario
	 * @return
	 * @throws SQLException
	 */
	public static String getPermisosAccesoByIdUsuario(String idUsuario) throws SQLException{
		String[][] permisosAcceso = AdPermisosAcceso.getPeticionesByIdUsuario(idUsuario);
		List<SolicitudAccesoVO> listasolicitudes = getInfoBDList(permisosAcceso);
		final Gson gson = new Gson();
		String permisosAccesoJSON = gson.toJson(listasolicitudes);
		return permisosAccesoJSON;
		
	}
	
	/**
	 * 
	 * @param solicitudes
	 * @return
	 */
	public static List<SolicitudAccesoVO> getInfoBDList(String[][] solicitudes){
		
		List<SolicitudAccesoVO> listaSolicitudes = new ArrayList<SolicitudAccesoVO>();
		
		for(int i = 0; i<solicitudes.length; i++){
			SolicitudAccesoVO solicitudAccesoVO = new SolicitudAccesoVO(solicitudes[i][0],solicitudes[i][1],solicitudes[i][2],solicitudes[i][3],solicitudes[i][4]);
			
			listaSolicitudes.add(solicitudAccesoVO);
		}
		
		return listaSolicitudes;
		
	}
		
public static String updateEstadoActivador(String idSolicitud, String estado) throws SQLException{

			AdPermisosAcceso.updateEstadoSolicitud(idSolicitud, estado);
		
		
		
		return "1";
	}
	
	
	

}
