package pe.edu.upc.hamp.dao;

import java.util.List;

import pe.edu.upc.hamp.entity.Customer;

public interface ICustomerDAO {
	public void create(Customer c);
	public void delete(int id);
	public void update(Customer c);
	public List<Customer> reader();
	public Customer getById(int id);
}
