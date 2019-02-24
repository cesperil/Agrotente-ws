package es.cem.batch;

import java.sql.SQLException;
import java.util.Date;

import es.cem.ln.LnAlertas;
import es.cem.ln.LnMedicionesSensores;
import es.cem.utilidades.Constantes;
import es.cem.utilidades.EnvioMail;
import es.cem.utilidades.TratamientoFechas;

public class EnvioAlertas {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 /*String destinatario =  "carlos.esperilla@gmail.com"; //A quien le quieres escribir.
		    String asunto = "Correo de prueba enviado desde Agrotente."; 
		    String cuerpo = "Tallo";

		
		 EnvioMail.enviarConGMail(destinatario, asunto, cuerpo);/*/
		
		
		 int retorno = 0;
		try {
			retorno = lanzaAlerta(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retorno = Constantes.PROCESO_KO;
		}
		 System.out.println(retorno);
		 
	}
	
	
	public static int lanzaAlerta(int tipo) throws SQLException{
		int estado = 1;
		
		switch (tipo) {
		case Constantes.TIPO_ALERTA_TEMPERATURA:
			estado = LnAlertas.envioAlertasTemperatura();
			break;
			
		case Constantes.TIPO_ALERTA_ECONOMICA:
			String fechaHasta = TratamientoFechas.getTimestamp(new Date());
			String fechaDesde = TratamientoFechas.getTimestamp(TratamientoFechas.AddAnio(new Date(), -1));
			estado = LnAlertas.envioAlertasMovimientosEconomicos(fechaDesde, fechaHasta);
			break;
			
		case Constantes.TIPO_ALERTA_ACCESO_PARCELA:
			estado = LnAlertas.envioAlertasAccesoParcelasUsuario();
			break;

		default:
			break;
		}
		
		return estado;
	}

}
