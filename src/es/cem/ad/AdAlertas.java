package es.cem.ad;

import java.sql.SQLException;

public class AdAlertas extends AdGeneric {

	public static String[][] getAlertasActivasTemperatura() throws SQLException{
		
		
		String sql = "select usu.correo_electronico, pa.fk_tipo_alerta, pa.valor_min, pa.valor_max, med.medicion, med.fecha_alta from `bo_parametros_alertas` pa "
				+ "			INNER join com_usuarios usu on pa.fk_usuario = usu.id "
				+ "			INNER JOIN com_mediciones med on med.fk_ide_sensor in (select id from com_sensor where fk_ide_tipo_sensor =1) "
				+ " where activa = '1' and fk_tipo_alerta = '1' and (med.medicion < pa.valor_min or med.medicion > pa.valor_max) "
				+ "	order by med.fecha_alta DESC";
		return selectMatriz(sql);
	}
	
	public static String[][] getAlertasMovimientosEconomicos(String fechaDesde, String fechaHasta) throws SQLException{
		String sql = "select email, importe, parcela, token from "
					+"(SELECT us.correo_electronico as email, sum(importe) as importe, pa.nombre as parcela, us.token_fcm as token " 
					+"FROM `ge_movimiento_economico` me  "
					+"inner join com_usuarios us on us.id = me.fk_ide_usuario "
					+"left outer join com_parcelas pa on pa.id = me.fk_ide_parcela "
					+" where fecha BETWEEN '"+fechaDesde+"' and '"+fechaHasta+"'  GROUP by 3, 1) me ";
		return selectMatriz(sql);
	}
	
}
