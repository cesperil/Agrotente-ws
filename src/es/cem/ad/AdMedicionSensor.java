package es.cem.ad;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


public class AdMedicionSensor extends AdGeneric {

	public static void insertMedidaSensor(int idSensor, String valorMedicion) throws SQLException{
		String sql = "INSERT INTO `com_mediciones` (fk_ide_sensor,medicion) "
				+ " VALUES "
				+ " ("
				+ ""+idSensor+", "
				+ ""+valorMedicion+" "
						+ ")";
		insert(sql);		
	}
	
	public static void insertMedidasMaxMinParametro(int parcela, int tipoMedicion, String diaInicio, String diaFin) throws SQLException{
		
	
		String sql = "INSERT INTO `com_med_max_min`(max, min, fk_ide_sensor, fecha_dia) "
				+ " Select MAX(medicion), MIN(medicion), sensor.id, '"+diaInicio+"' from com_mediciones medicion "
				+ "		inner join com_sensor sensor on medicion.fk_ide_sensor = sensor.id "
				+ "			and sensor.fk_ide_parcela = "+parcela+" AND sensor.fk_ide_tipo_sensor = "+tipoMedicion+" "
				+ "				where medicion.fecha_alta BETWEEN '"+diaInicio.toString()+"' and '"+diaFin.toString()+"'";
		insert(sql);
	}
	

	public static void insertMedidasMaxMinTemperatura(int parcela, int tipoMedicion, String diaInicio, String diaFin) throws SQLException{
		
	
		String sql = "INSERT INTO `com_med_max_min_temp`(max, min, fk_ide_sensor, fk_ide_parcela, fecha_dia) "
				+ " Select MAX(medicion), MIN(medicion), sensor.id, "+parcela+" ,'"+diaInicio+"' from com_mediciones medicion "
				+ "		inner join com_sensor sensor on medicion.fk_ide_sensor = sensor.id "
				+ "			and sensor.fk_ide_parcela = "+parcela+" AND sensor.fk_ide_tipo_sensor = "+tipoMedicion+" "
				+ "				where medicion.fecha_alta BETWEEN '"+diaInicio.toString()+"' and '"+diaFin.toString()+"'";
		insert(sql);
	}
	
	
	public static void insertMedidasMaxMinHumedad(int parcela, int tipoMedicion, String diaInicio, String diaFin) throws SQLException{
		
		
		String sql = "INSERT INTO `com_med_max_min_hum`(max, min, fk_ide_sensor, fk_ide_parcela, fecha_dia) "
				+ " Select MAX(medicion), MIN(medicion), sensor.id, "+parcela+" ,'"+diaInicio+"' from com_mediciones medicion "
				+ "		inner join com_sensor sensor on medicion.fk_ide_sensor = sensor.id "
				+ "			and sensor.fk_ide_parcela = "+parcela+" AND sensor.fk_ide_tipo_sensor = "+tipoMedicion+" "
				+ "				where medicion.fecha_alta BETWEEN '"+diaInicio.toString()+"' and '"+diaFin.toString()+"'";
		insert(sql);
	}
	
	
	
	/**
	 * 
	 * @param idParcela
	 * @return
	 * @throws SQLException
	 */
	public static String[][] getMedicionesParcela(String idParcela) throws SQLException{
		
		String sql = "select max, min, fecha_dia, ts.nombre "
				+ "from com_med_max_min_temp mt "
				+ "INNER JOIN com_sensor s on s.id = mt.fk_ide_sensor "
				+ "INNER JOIN com_tipos_sensores ts on s.fk_ide_tipo_sensor = ts.id where mt.fk_ide_parcela = 1 "
			+ "UNION "
				+ "select max, min, fecha_dia, ts2.nombre "
			+ "from com_med_max_min_hum mh "
			+ "INNER JOIN com_sensor s2 on s2.id = mh.fk_ide_sensor "
			+ "INNER JOIN com_tipos_sensores ts2 on s2.fk_ide_tipo_sensor = ts2.id "
			+ "where mh.fk_ide_parcela =  "+ idParcela + " "
			+ "ORDER BY `fecha_dia` DESC";
		
		return selectMatriz(sql);
		
	}
	
	
}
