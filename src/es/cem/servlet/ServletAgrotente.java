package es.cem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.cem.ln.ContadorParking;
import es.cem.ln.LnMedicionesSensores;
import es.cem.utilidades.ConexionAgrotenteBD;
import es.cem.utilidades.Constantes;
import es.cem.utilidades.TratamientoDeDatos;

/**
 * Servlet implementation class ServletSmartParking
 */
@WebServlet("/")
public class ServletAgrotente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//int contador;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgrotente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(5);
		response.setContentType("text/plain");
		
		/*String paramName = "temp/hum";
		String paramValue = request.getParameter(paramName);
		if(paramValue != null && !"".equals(paramValue)){
			String temperatura = paramValue.split(":")[0];
			LnMedicionesSensores.insertaMedicion(1, temperatura);
		}*/
		
		if(TratamientoDeDatos.esNullCeroVacio(request.getParameter("app"))){
			try {
				ProcesoRequest.procesoRequest(request);
			} catch (SQLException e) {
				// TODO Auto-generated catch block	
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			out.println("El servicio esta levantado correctamente");
		}else{
			try {
				String respuesta= ProcesoRequest.procesoRequestApp(request);
				PrintWriter out = response.getWriter();
				out.println(respuesta);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	    
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post");
		
		
	}
	
	@Override
	public void init(){
		
		
	}
	
	public void destroy(){
		
	}

}
