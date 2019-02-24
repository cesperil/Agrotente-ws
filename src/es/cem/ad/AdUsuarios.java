package es.cem.ad;

import java.sql.SQLException;

public class AdUsuarios extends AdGeneric{

	public static String[] loginUsuarioApp(String username, String password) throws SQLException{
		
		String sql = "SELECT * "
				+ " FROM com_usuarios "
				+ " where username =  '"+username+"' and password ='"+password+"'";
		return select(sql);
	}
	
	public static void updateTokenFCMUsuario(String idUsuario, String tokenFCM) throws Exception{
		String sql = "update com_usuarios "
				+ " set  token_fcm = '" + tokenFCM + "' " 
				+ " where id = " + idUsuario;
		update(sql);
	}
	
}
