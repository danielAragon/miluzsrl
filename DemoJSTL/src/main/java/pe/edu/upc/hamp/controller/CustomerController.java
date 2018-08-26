package pe.edu.upc.hamp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.upc.hamp.dao.ICustomerDAO;
import pe.edu.upc.hamp.dao.impl.CustomerDAO;
import pe.edu.upc.hamp.entity.Customer;


@WebServlet("/customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	public static final String LIST_CUSTOMER="/listCustomer.jsp";
	public static final String INSERT_EDIT="/customer.jsp";

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ICustomerDAO dao=new CustomerDAO();		
		String redireccion="";
		String accion=request.getParameter("accion");
		
		if(accion.equalsIgnoreCase("DELETE")) {
			redireccion=LIST_CUSTOMER;
			int id=Integer.parseInt(request.getParameter("id"));
			dao.delete(id);
			//Controlador envia la lista customers actualizado
			request.setAttribute("customers", dao.reader());
		}else if(accion.equalsIgnoreCase("EDIT")) {
			redireccion=INSERT_EDIT;
			int id=Integer.parseInt(request.getParameter("id"));
			Customer customer=dao.getById(id);
			request.setAttribute("customer", customer);
		}else if(accion.equalsIgnoreCase("CREATE")) {
			redireccion=INSERT_EDIT;
		}else {
			redireccion=LIST_CUSTOMER;
			request.setAttribute("customers", dao.reader());
		}
		
		RequestDispatcher vista=request.getRequestDispatcher(redireccion);		
		vista.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		ICustomerDAO dao=new CustomerDAO();	
		
		Customer customer=new Customer();
		customer.setName(name);
		
		dao.create(customer);

		
		RequestDispatcher vista=request.getRequestDispatcher(LIST_CUSTOMER);
		request.setAttribute("customers", dao.reader());
		vista.forward(request, response);
	}

}
