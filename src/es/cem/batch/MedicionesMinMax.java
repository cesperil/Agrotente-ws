package es.cem.batch;

import java.sql.SQLException;
import java.util.Date;

import es.cem.ln.LnMedicionesSensores;
import es.cem.utilidades.TratamientoFechas;

public class MedicionesMinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date fecha = new Date();
		//fecha = TratamientoFechas.AddDia(fecha, -1);
		
		try {
			LnMedicionesSensores.insertMinMaxTemperatura(fecha);
			LnMedicionesSensores.insertMinMaxHumedad(fecha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
