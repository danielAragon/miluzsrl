package pe.edu.upc.hamp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.hamp.dao.INotitaDAO;
import pe.edu.upc.hamp.entity.Notita;

public class NotitaDAO implements INotitaDAO {
	
	private Connection cx;
	
	public NotitaDAO() {
		cx = Conexion.conectar();
	}
	
	@Override
	public void create(Notita notita) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Nota(name,grade,status) VALUES(?,?,?)";
		try {
			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setString(1, notita.name);
			ps.setInt(2, notita.grade);
			ps.setInt(3, (notita.status)?1:0);
			ps.executeQuery();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(Notita notita) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Nota SET name=?,grade=?,status=? WHERE id=?";
		try {
			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setString(1, notita.name);
			ps.setInt(2, notita.grade);
			ps.setInt(3, (notita.status)?1:0);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<Notita> read() {
		// TODO Auto-generated method stub
		List<Notita> notitas = new ArrayList<>();
		String sql = "SELECT id,name,grade,status FROM Nota";
		try {
			Statement st = cx.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Notita notita = new Notita();
				notita.id = rs.getInt("id");
				notita.name = rs.getString("name");
				notita.grade = rs.getInt("grade");
				notita.status = rs.getBoolean("status");
				notitas.add(notita);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return notitas;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Notita getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
