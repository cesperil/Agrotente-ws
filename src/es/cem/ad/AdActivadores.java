package es.cem.ad;

import java.sql.SQLException;

public class AdActivadores extends AdGeneric{

	/**
	 * 
	 * @param idUsuario
	 * @return
	 * @throws SQLException 
	 */
	public static String[][] getActivadoresByUsuario(String idUsuario) throws SQLException{
		
		String sql =  "select ac.id, ac.estado, ac.fk_ide_parcela, pa.nombre "  
					+	"from com_activadores ac "
					+	"inner join com_parcelas pa on pa.id = ac.fk_ide_parcela "
					+	"where ac.fk_ide_usuario = 1";
		
		return selectMatriz(sql);
	}
	
	/**
	 * 
	 * @param idUsuario
	 * @return
	 * @throws SQLException 
	 */
	public static void updateEstadoActivador(String idActivador, String estado) throws SQLException{
		
		String sql =  "update com_activadores "  
					+	" set estado = " + estado 
					+	" where id = " + idActivador;
		
		update(sql);
	}
	
	public static String[] getIpActivadorById(String idActivador) throws SQLException{
		
		String sql =  " select ip_activador from com_activadores "
				+ " where id = " + idActivador;
		
		return select(sql);
		
	}
	
}
