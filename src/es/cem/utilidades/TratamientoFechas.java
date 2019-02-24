package es.cem.utilidades;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TratamientoFechas {

	/**
	 * Obtiene un timestamp a partir de una fecha
	 * 2018-05-31 12:47:27
	 * @param fecha
	 * @return
	 */
	public static String getTimestamp(Date fecha) {
		String stTimestamp;
		stTimestamp = TratamientoDeDatos.cerosAIzquierda(
				TratamientoDeDatos.sNoNull(getAnio(fecha)), 4);
		stTimestamp += TratamientoDeDatos.cerosAIzquierda(
				TratamientoDeDatos.sNoNull(getMes(fecha)), 2);
		stTimestamp += TratamientoDeDatos.cerosAIzquierda(
				TratamientoDeDatos.sNoNull(getDia(fecha)), 2);
		stTimestamp += TratamientoDeDatos.cerosAIzquierda(
				TratamientoDeDatos.sNoNull(getHora(fecha)), 2);
		stTimestamp += TratamientoDeDatos.cerosAIzquierda(
				TratamientoDeDatos.sNoNull(getMinutos(fecha)), 2);
		stTimestamp += TratamientoDeDatos.cerosAIzquierda(
				TratamientoDeDatos.sNoNull(getSegundos(fecha)), 2);

		return stTimestamp;

	}
	
	/**
	 * Obtiene un timestamp a partir de una fecha
	 * @param fecha
	 * @return
	 */
	public static String getTimestampDia(Date fecha) {
		String stTimestamp;
		stTimestamp = TratamientoDeDatos.cerosAIzquierda(
				TratamientoDeDatos.sNoNull(getAnio(fecha)), 4);
		stTimestamp +="-"+ TratamientoDeDatos.cerosAIzquierda(
				TratamientoDeDatos.sNoNull(getMes(fecha)), 2);
		stTimestamp +="-"+ TratamientoDeDatos.cerosAIzquierda(
				TratamientoDeDatos.sNoNull(getDia(fecha)), 2);
		stTimestamp +=" " + "00";
		stTimestamp +=":" + "00";
		stTimestamp +=":" + "00";

		return stTimestamp;

	}
	
	
	public static final Date AddAnio(Date Fecha, Integer cantidad) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(Fecha);
		int campoAnio = Calendar.YEAR;
		cal.add(campoAnio, cantidad);
		return cal.getTime();
	}

	public static final Date AddDia(Date Fecha, Integer cantidad) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(Fecha);
		int campoDia = Calendar.DAY_OF_MONTH;
		cal.add(campoDia, cantidad);
		return cal.getTime();
	}

	public static String getAnio(Date fecha) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		return Integer.toString(calendar.get(Calendar.YEAR));
	}

	/**
	 * Obtener el anio de una fecha.
	 * 
	 * @param fecha
	 *            - Date
	 * @return Integer
	 */
	public static Integer getAnioInteger(Date fecha) {
		Integer anioInteger = Integer.valueOf(0);
		try {
			if (fecha != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(fecha);
				anioInteger = calendar.get(Calendar.YEAR);
			}
		} catch (Exception e) {
			anioInteger = Integer.valueOf(0);
		}
		return anioInteger;
	}

	public static String getMes(Date fecha) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		return Integer.toString(calendar.get(Calendar.MONTH) + 1);
	}

	public static String getDia(Date fecha) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		return Integer.toString(calendar.get(Calendar.DATE));
	}
	
	/**
	 * Devuelve las horas de un Date
	 * 
	 * @param fecha
	 * @return
	 */
	public static String getHora(Date fecha) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		String stHora = Integer.toString(calendar.get(Calendar.HOUR));
		return stHora;
	}

	/**
	 * Devuelve los minutos de un Date
	 * 
	 * @param fecha
	 * @return
	 */
	public static String getMinutos(Date fecha) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		String stMin = Integer.toString(calendar.get(Calendar.MINUTE));
		return stMin;
	}

	/**
	 * Devuelve los segundos de un Date
	 * 
	 * @param fecha
	 * @return
	 */
	public static String getSegundos(Date fecha) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		String stSeg = Integer.toString(calendar.get(Calendar.SECOND));
		return stSeg;
	}
	
}
