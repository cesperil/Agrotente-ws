package es.cem.servlet;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import es.cem.VO.UsuariosVO;
import es.cem.ln.LnActivadores;
import es.cem.ln.LnMedicionesSensores;
import es.cem.ln.LnParcelas;
import es.cem.ln.LnPermisosAcceso;
import es.cem.ln.LnUsuarios;
import es.cem.utilidades.TratamientoDeDatos;
import es.cem.utilidades.UtilidadesJSON;

public class ProcesoRequest {

	public static final String REQ_TEMPERATURA = "temperatura";
	public static final String REQ_HUMEDAD	   = "humedad";
	
	public static final String REQ_INFORMACION_USUARIO 	= "userInfo";
	public static final String REQ_PARCELAS_POR_USUARIO = "parcelasInfo";
	public static final String REQ_PARCELAS_POR_ID		= "parcelasIdInfo";
	public static final String REQ_ACTIVADORES_POR_USUARIO = "activadoresInfo";
	public static final String REQ_MEDICIONES_PARCELA	= "medParcelasInfo";
	public static final String REQ_SOLICITUDES_ACCESO_POR_USUARIO  = "solicitudesAccesoInfo";
	
	
	public static final String REQ_UPDATE_ESTADO_ACTIVADOR	= "updateEstadoActivador";
	public static final String REQ_UPDATE_ESTADO_SOLICITUD_ACCESO= "updateEstadoSolicitudAcceso";
	public static final String REQ_UPDATE_TOKEN_FCM			= "updateTokenFCM";
	
	
	public static void procesoRequest(HttpServletRequest request) throws SQLException{
		
		
		String paramValue = request.getParameter(REQ_TEMPERATURA);
		if(!TratamientoDeDatos.esNullVacio(paramValue)){
			LnMedicionesSensores.procesaMedicion(paramValue);
		}
		
		paramValue = request.getParameter(REQ_HUMEDAD);
		if(!TratamientoDeDatos.esNullVacio(paramValue)){
			LnMedicionesSensores.procesaMedicion(paramValue);
		}
		
		
	}
	
	
	
	public static String procesoRequestApp(HttpServletRequest request) throws SQLException{
		
		String respuesta = "";
		try {
			String paramValue = request.getParameter(REQ_INFORMACION_USUARIO);
			if(!TratamientoDeDatos.esNullVacio(paramValue)){
				//obtener datos Json
				UsuariosVO usuario = (UsuariosVO) UtilidadesJSON.jsonToObject(paramValue, UsuariosVO.class);
				respuesta = LnUsuarios.loginApp(usuario);
			}
			
			paramValue = request.getParameter(REQ_PARCELAS_POR_USUARIO);
			if(!TratamientoDeDatos.esNullVacio(paramValue)){
				//obtener datos Json
				String idUsuario = paramValue;
				respuesta = LnParcelas.getParcelasByUsuario(idUsuario);
			}
			
			paramValue = request.getParameter(REQ_ACTIVADORES_POR_USUARIO);
			if(!TratamientoDeDatos.esNullVacio(paramValue)){
				//obtener datos Json
				String idUsuario = paramValue;
				respuesta = LnActivadores.getActivadoresByUsuario(idUsuario);
			}
			
			paramValue = request.getParameter(REQ_UPDATE_ESTADO_ACTIVADOR);
			if(!TratamientoDeDatos.esNullVacio(paramValue)){
				
				String idActivador = paramValue;
				String nuevoEstado = request.getParameter("estadoNuevo");
				respuesta = LnActivadores.updateEstadoActivador(idActivador, nuevoEstado);
			}
			
			paramValue = request.getParameter(REQ_UPDATE_ESTADO_SOLICITUD_ACCESO);
			if(!TratamientoDeDatos.esNullVacio(paramValue)){
				String idSolicitud = paramValue;
				String nuevoEstado = request.getParameter("estadoNuevo");
				respuesta = LnPermisosAcceso.updateEstadoActivador(idSolicitud, nuevoEstado);
			}
			
			
			paramValue = request.getParameter(REQ_PARCELAS_POR_ID);
			if(!TratamientoDeDatos.esNullVacio(paramValue)){
				
				String idParcela = paramValue;
				respuesta = LnParcelas.getParcelasById(idParcela);
			}
			
			paramValue = request.getParameter(REQ_MEDICIONES_PARCELA);
			if(!TratamientoDeDatos.esNullVacio(paramValue)){
				
				String idParcela = paramValue;
				respuesta = LnMedicionesSensores.getMedicionesParcela(idParcela);
			}
			
			
			paramValue = request.getParameter(REQ_UPDATE_TOKEN_FCM);
			if(!TratamientoDeDatos.esNullVacio(paramValue)){
				
				String idUsuario = request.getParameter("idUsuario");
				String tokenFCM  = request.getParameter("tokenFCM");
				
				respuesta = LnUsuarios.updateTokenFCM(idUsuario, tokenFCM);
			}
			
			paramValue = request.getParameter(REQ_SOLICITUDES_ACCESO_POR_USUARIO);
			if(!TratamientoDeDatos.esNullVacio(paramValue)){
				
				String idUsuario = request.getParameter("idUsuario");
				
				respuesta = LnPermisosAcceso.getPermisosAccesoByIdUsuario(idUsuario);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return respuesta;
		
	}
	
}
