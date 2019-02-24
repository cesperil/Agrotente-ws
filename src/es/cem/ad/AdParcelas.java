package es.cem.ad;

import java.sql.SQLException;

public class AdParcelas extends AdGeneric {

	/**
	 * Obtiene las parcelas para un usuario
	 * @param idUsuario
	 * @return
	 * @throws SQLException
	 */
	public static String[][] getParcelasByIdUsuario(String idUsuario) throws SQLException{
		String sql = "select id, nombre, latitud, longitud "
				+ " from com_parcelas "
				+ " where fk_ide_usuario = " + idUsuario;
		return selectMatriz(sql);
	}
	
	
	/**
	 * Obtiene las parcelas segun su id
	 * @param idParcela
	 * @return
	 * @throws SQLException
	 */
	public static String[] getParcelaById(String idParcela) throws SQLException{
		String sql = "select id, nombre, latitud, longitud, cod_municipio, poligono, parcela, fecha_alta "
				+ " from com_parcelas "
				+ " where id = " + idParcela;
		return selectMatriz(sql)[0];
	}
	
}
