package es.cem.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.cem.utilidades.TratamientoDeDatos;

public class AdGeneric {

	public static void insert(String insert) throws SQLException{
		
		 Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
            //Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrotente", "root", "");
            //Statement st = conexion.createStatement();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrotente", "root", "");
			Statement st = conexion.createStatement();
	        st.executeUpdate(insert);
	        System.out.println(insert);
	        
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conexion.close();
		}
	}
	
	
	public static void update(String insert) throws SQLException{
		
		 Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
           //Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrotente", "root", "");
           //Statement st = conexion.createStatement();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrotente", "root", "");
			Statement st = conexion.createStatement();
	        st.executeUpdate(insert);
	        System.out.println(insert);
	        
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conexion.close();
		}
	}
	
	
	public static String[] select(String select) throws SQLException{
		
		 Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
           //Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrotente", "root", "");
           //Statement st = conexion.createStatement();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrotente", "root", "");
			Statement st = conexion.createStatement();
			System.out.println(select);
	        ResultSet rs =  st.executeQuery(select);
	        
	        ArrayList<String> resultado = new ArrayList<String>();
	        int i=0;
	        while (rs.next()) 
	        { 
	        	i++;
	        	resultado.add(rs.getString(i));
	        }
	        
	        String[] resultadoArr = new String[resultado.size()];
	        return resultado.toArray(resultadoArr);
	        
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conexion.close();
		}
		
		return null;
	}
	
	
	public static String[][] selectMatriz(String select) throws SQLException{
		
		 Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
          //Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrotente", "root", "");
          //Statement st = conexion.createStatement();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrotente", "root", "");
			Statement st = conexion.createStatement();
			System.out.println(select);
	        ResultSet rs =  st.executeQuery(select);
	        
	       
	        int j = 0;
	        ResultSetMetaData rsmd = rs.getMetaData();
	        
	        int numCols = rsmd.getColumnCount();
	 
	        int numFilas = 0;
	        while (rs.next()) {
	            ++numFilas;
	        }
	        
	        ArrayList<String> resultado = new ArrayList<String>();
	       // int i=0;
	        String obj[][]= new String[numFilas][numCols];
	        rs.beforeFirst();
	        while (rs.next()) 
	        { 
	        	for (int i=0;i<numCols;i++)
	            {
	 
	                obj[j][i]= TratamientoDeDatos.sNoNull(rs.getObject(i+1));
	            }
	            j++;
	        }
	        
	       
	        
	        return obj; 
	        
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conexion.close();
		}
		
		return null;
	}
	
}
