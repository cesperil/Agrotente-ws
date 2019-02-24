package es.cem.ln;

import java.sql.Date;
import java.sql.SQLException;

import es.cem.ad.AdAlertas;
import es.cem.notificaciones.FCM;
import es.cem.utilidades.Constantes;
import es.cem.utilidades.EnvioMail;
import es.cem.utilidades.TratamientoDeDatos;

public class LnAlertas {

	public static int envioAlertasTemperatura() throws SQLException{
		String[][] info = AdAlertas.getAlertasActivasTemperatura();
		
		for(int i=0; i<info.length; i++){
			String correoElectronico = TratamientoDeDatos.sNoNull(info[i][0]);
			String valorMedicion     = TratamientoDeDatos.sNoNull(info[i][4]);
			String fechaAlta 		 = TratamientoDeDatos.sNoNull(info[i][5]);
			EnvioMail.enviarConGMail(correoElectronico, "Alerta Temperatura", "Se ha detectado que la temperatura es elevada: " + valorMedicion + " ºC con fecha " + fechaAlta);
			
		}
		
		return Constantes.PROCESO_OK;
		
	}
	
	/**
	 * Envio de alertas por movimientos economicos
	 * @param fechaDesde
	 * @param fechaHasta
	 * @return
	 * @throws SQLException
	 */
	public static int envioAlertasMovimientosEconomicos(String fechaDesde, String fechaHasta) throws SQLException{
		
		String[][] info = AdAlertas.getAlertasMovimientosEconomicos(fechaDesde, fechaHasta);
		
		for(int i=0; i<info.length; i++){
			String correoElectronico = TratamientoDeDatos.sNoNull(info[i][0]);
			String importe		     = TratamientoDeDatos.sNoNull(info[i][1]);
			String parcela 		 	 = TratamientoDeDatos.sNoNull(info[i][2]);
			String tokenFCM 		 = TratamientoDeDatos.sNoNull(info[i][3]);
			
			if(TratamientoDeDatos.esNullCeroVacio(parcela)){
				parcela= " Gastos Transversales";
			}
			
			EnvioMail.enviarConGMail(correoElectronico, "Alertas Movimiento Economico", "Resultado de movimientos económicos para : " + parcela + "\n"
					+ " Con resultado " + importe);
			
			FCM.send_FCM_Notification(tokenFCM, FCM.SERVER_APY_KEY, "Alertas Movimiento Economico",  "Resultado de movimientos económicos para : " + parcela + "\n"
					+ " Con resultado " + importe);
			
		}
		
		return Constantes.PROCESO_OK;
		
	}
	
	
	/**
	 * Envio de alertas por solicitud de acceso a usuario
	 * @param fechaDesde
	 * @param fechaHasta
	 * @return
	 * @throws SQLException
	 */
	public static int envioAlertasAccesoParcelasUsuario() throws SQLException{
		
		String[][] info = LnPermisosAcceso.getPermisosAccesoBatch(LnPermisosAcceso.ESTADO_PTE_RESPUESTA);
		
		for(int i=0; i<info.length; i++){
			String nombreParcela 	= TratamientoDeDatos.sNoNull(info[i][0]);
			String nombreUsuario	= TratamientoDeDatos.sNoNull(info[i][1]);
			String tokenFCM 		= TratamientoDeDatos.sNoNull(info[i][2]);
			String correoElectronico= TratamientoDeDatos.sNoNull(info[i][3]);
			
			EnvioMail.enviarConGMail(correoElectronico, "Solicitud de Acceso", "Solicitud de acceso para : " + nombreParcela + "\n"
					+ " por parte de: " + nombreUsuario.toUpperCase());
			
			FCM.send_FCM_Notification(tokenFCM, FCM.SERVER_APY_KEY, "Solicitud de Acceso",  "Solicitud de acceso para : " + nombreParcela + "\n"
					+ " por parte de: " + nombreUsuario.toUpperCase());
		}
		
		return Constantes.PROCESO_OK;
		
	}
	
}
