package pe.edu.upc.hamp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.upc.hamp.dao.INotitaDAO;
import pe.edu.upc.hamp.dao.impl.NotitaDAO;

/**
 * Servlet implementation class NotitaController
 */
@WebServlet("/nota")
public class NotitaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String LISTAR = "/listNota.jsp";
    public static final String CREAR_EDITAR = "/nota.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotitaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		INotitaDAO dao = new NotitaDAO();
		String redireccion = "";
		String accion = request.getParameter("accion");
		if(accion.equalsIgnoreCase("CREATE")) {
			redireccion = CREAR_EDITAR;
		}else {
			redireccion = LISTAR;
			//request.setAttribute()
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
