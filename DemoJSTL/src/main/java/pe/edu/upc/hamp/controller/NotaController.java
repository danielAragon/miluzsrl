package pe.edu.upc.hamp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.upc.hamp.dao.INotaDAO;
import pe.edu.upc.hamp.dao.impl.NotaDAO;
import pe.edu.upc.hamp.entity.Nota;


@WebServlet("/notatest")
public class NotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public static final String LIST_NOTA = "/listNota.jsp";
    public static final String INSERT_EDIT = "/nota.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		INotaDAO dao = new NotaDAO();
		String redireccion = "";
		String accion = request.getParameter("accion");
		
		if(accion.equalsIgnoreCase("CREATE")) {
			redireccion = INSERT_EDIT;
		}else if(accion.equalsIgnoreCase("DELETE")) {
			redireccion = LIST_NOTA;
			int id = Integer.parseInt(request.getParameter("id"));
			dao.delete(id);
			request.setAttribute("notas", dao.reader());
		}else if(accion.equalsIgnoreCase("EDIT")) {
			redireccion = INSERT_EDIT;
			int id = Integer.parseInt(request.getParameter("id"));
			Nota nota = dao.getById(id);
			request.setAttribute("nota", nota);
		}else{
			redireccion = LIST_NOTA;
			request.setAttribute("notas", dao.reader());
		}
		RequestDispatcher vista = request.getRequestDispatcher(redireccion);
		vista.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		INotaDAO dao = new NotaDAO();
		String accion = request.getParameter("accion");
		
		if(accion.equalsIgnoreCase("CREATE")) {
			Nota nota = new Nota();
			String name = request.getParameter("name");
			int grade = Integer.parseInt(request.getParameter("grade"));
			nota.setName(name);
			nota.setGrade(grade);
			nota.setStatus((grade>=13)?true:false);
			dao.create(nota);
		}else {
			Nota nota = new Nota();
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int grade = Integer.parseInt(request.getParameter("grade"));
			boolean status = grade>=13?true:false;
			nota.setId(id);
			nota.setName(name);
			nota.setGrade(grade);
			nota.setStatus(status);
			dao.update(nota);
		}
		
		RequestDispatcher vista = request.getRequestDispatcher(LIST_NOTA);
		request.setAttribute("notas", dao.reader());
		vista.forward(request, response);
	}

}
