package pe.edu.upc.hamp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import pe.edu.upc.hamp.dao.ICustomerDAO;
import pe.edu.upc.hamp.entity.Customer;

public class CustomerDAO implements ICustomerDAO {

	private Connection cx;
	
	public CustomerDAO() {
		// TODO Auto-generated constructor stub
		cx=Conexion.conectar();
	}
	
	@Override
	public void create(Customer c) {
		// TODO Auto-generated method stub
		try {
			String sql="INSERT INTO Customer(name) VALUES(?)";
			PreparedStatement pstm=cx.prepareStatement(sql);
			pstm.setString(1, c.getName());
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			String sql="DELETE FROM Customer Where Id=?";
			PreparedStatement pstm=cx.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void update(Customer c) {
		// TODO Auto-generated method stub
		try {
			String sql="UPDATE Customer SET name=? WHERE id=?";
			PreparedStatement pstm=cx.prepareStatement(sql);
			pstm.setString(1, c.getName());
			pstm.setInt(2, c.getId());
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> reader() {
		// TODO Auto-generated method stub
		List<Customer> customers=new ArrayList<>();
		
		try {
			Statement stm=cx.createStatement();
			ResultSet rs=stm.executeQuery("SELECT id,name FROM Customer");
			while(rs.next()) {
				Customer customer=new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customers.add(customer);
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return customers;
	}

	@Override
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		
		try {
			String query = "SELECT id,name FROM Customer WHERE id =?";
			PreparedStatement preparedStatement = cx.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customer.setId(resultSet.getInt("id"));
				customer.setName(resultSet.getString("name"));				
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
