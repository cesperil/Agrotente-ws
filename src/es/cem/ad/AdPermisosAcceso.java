package es.cem.ad;

import java.sql.SQLException;

public class AdPermisosAcceso extends AdGeneric {

	/**
	 * 
	 * @param idUsuario
	 * @return
	 * @throws SQLException 
	 */
	public static String[][] getPermisosByEstado(int estado) throws SQLException{
		
		String sql =  "Select pa.parcela, concat(usu1.nombre, ' ', usu1.apellido1, ' ', usu1.apellido2), usu2.token_fcm, usu2.correo_electronico " +
					" from ge_permiso_acceso pa " + 
					" inner join com_usuarios usu1 on usu1.id = pa.fk_ide_usu_sol " + 
					" inner join com_usuarios usu2 on usu2.id = pa.fk_ide_usu_res " + 
					" inner join com_parcelas par on par.nombre like pa.parcela and par.fk_ide_usuario=pa.fk_ide_usu_res " +
					" where pa.estado = " + estado; 
		
		return selectMatriz(sql);
	}
	
	
	/**
	 * 
	 * @param idUsuario
	 * @return
	 * @throws SQLException 
	 */
	public static String[][] getPeticionesByIdUsuario(String idUsuario) throws SQLException{
		
		String sql =  "Select pa.id, concat(usu1.nombre, ' ', usu1.apellido1, ' ', usu1.apellido2), pa.estado, par.id, par.nombre " +
					" from ge_permiso_acceso pa " + 
					" inner join com_usuarios usu1 on usu1.id = pa.fk_ide_usu_sol " + 
					" inner join com_usuarios usu2 on usu2.id = pa.fk_ide_usu_res " + 
					" inner join com_parcelas par on par.nombre like pa.parcela and par.fk_ide_usuario=pa.fk_ide_usu_res " +
					" where pa.fk_ide_usu_res = " + idUsuario; 
		
		return selectMatriz(sql);
	}
	
	
	/**
	 * 
	 * @param idSolicitud
	 * @param estado
	 * @throws SQLException
	 */
	public static void updateEstadoSolicitud(String idSolicitud, String estado) throws SQLException{
		
		String sql =  "update ge_permiso_acceso "  
					+	" set estado = " + estado 
					+	" where id = " + idSolicitud;
		
		update(sql);
	}
	
	
	
	
	
}
