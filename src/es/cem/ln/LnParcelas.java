package es.cem.ln;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import es.cem.VO.UsuariosVO;
import es.cem.VO.ParcelasVO;
import es.cem.ad.AdParcelas;
import es.cem.utilidades.TratamientoDeDatos;

public class LnParcelas {

	public static String getParcelasByUsuario(String idUsuario) throws SQLException{
		
		String[][] parcelas = AdParcelas.getParcelasByIdUsuario(idUsuario);
		
		final Gson gson = new Gson();
		ArrayList<ParcelasVO> listaParcelas = getInfoBDList(parcelas);
 		String parcelasJSON = gson.toJson(listaParcelas);
		return parcelasJSON;
	}
	
	
	public static ArrayList<ParcelasVO> getInfoBDList(String[][] parcelas){
		
		ArrayList<ParcelasVO> listaParcelas = new ArrayList<ParcelasVO>();
		if(!TratamientoDeDatos.esNullCeroVacio(parcelas)){
			for(int i = 0; i<parcelas.length; i++){
				
				ParcelasVO parcelaVO = new ParcelasVO(parcelas[i][0], parcelas[i][1], parcelas[i][2], parcelas[i][3]);
				listaParcelas.add(parcelaVO);
				
			}
		}
		
		return listaParcelas;
	}
	
	public static String getParcelasById(String idParcela) throws SQLException{
		
		String[] parcelas 	= AdParcelas.getParcelaById(idParcela);
		
		final Gson gson 	= new Gson();
		ParcelasVO parcela = getInfoBD(parcelas);
 		String parcelaJSON = gson.toJson(parcela);
		return parcelaJSON;
	}
	
	
	public static ParcelasVO getInfoBD(String[] parcelas){
				
		ParcelasVO parcelaVO = new ParcelasVO(parcelas[0], parcelas[1], parcelas[2], parcelas[3], 
				parcelas[4], parcelas[5], parcelas[6], parcelas[7]);
		
		return parcelaVO;
	}
	
	
}
