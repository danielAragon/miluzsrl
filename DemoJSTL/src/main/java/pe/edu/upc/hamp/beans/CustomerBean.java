package pe.edu.upc.hamp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import pe.edu.upc.hamp.dao.ICustomerDAO;
import pe.edu.upc.hamp.dao.impl.CustomerDAO;
import pe.edu.upc.hamp.entity.Customer;

@ManagedBean(name="customerBean")
public class CustomerBean {
	private List<Customer> customers;
	private Customer customer;	
	private ICustomerDAO dao;//Data Access Object

	public CustomerBean() {
		customers=new ArrayList<>();		
		dao=new CustomerDAO();
		reader();
	}

	public void create() {
		dao.create(customer);
	}
	
	public void reader() {
		customers=dao.reader();
	}
	
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
