package es.cem.ln;

import java.sql.SQLException;

import es.cem.VO.UsuariosVO;
import es.cem.ad.AdUsuarios;
import es.cem.utilidades.TratamientoDeDatos;

public class LnUsuarios {

	public static String loginApp (UsuariosVO usuarios) throws SQLException{
		
		String[] usuario =  AdUsuarios.loginUsuarioApp(usuarios.getUser(), usuarios.getPass());
		
		if(usuario != null && usuario.length > 0){
			return usuario[0];
		}
		return "error";
	}
	
	/**
	 * Actualiza el valor del campo token_fcm de com_usuarios a partir del id del usuario
	 * @param idUsuario
	 * @param tokenFCM
	 * @throws Exception
	 */
	public static String updateTokenFCM(String idUsuario, String tokenFCM) throws Exception{
		AdUsuarios.updateTokenFCMUsuario(idUsuario, tokenFCM);
		return "1";
	}
	
}
