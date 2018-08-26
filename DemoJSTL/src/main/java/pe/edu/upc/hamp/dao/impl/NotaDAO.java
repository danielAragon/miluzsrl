package pe.edu.upc.hamp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.hamp.dao.INotaDAO;
import pe.edu.upc.hamp.entity.Nota;

public class NotaDAO implements INotaDAO {

	private Connection cx;
	
	
	public NotaDAO() {
		cx = Conexion.conectar();
	}
	
	@Override
	public void create(Nota c) {
		// TODO Auto-generated method stub
		try {
			String sql = "INSERT INTO Nota(name,grade,status) VALUES('"+c.getName()+"','"+c.getGrade()+"','"+((c.getStatus())?1:0)+"')";
			PreparedStatement pstm = cx.prepareStatement(sql);
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "DELETE FROM Nota WHERE id=?";
			PreparedStatement pstm = cx.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void update(Nota c) {
		// TODO Auto-generated method stub
		try {
			String query = "UPDATE Nota SET name='"+c.getName()+"',grade='"+c.getGrade()+"',status='"+((c.getStatus())?1:0)+"' WHERE id=?";
			PreparedStatement pstm = cx.prepareStatement(query);
			pstm.setInt(1, c.getId());
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<Nota> reader() {
		// TODO Auto-generated method stub
		List<Nota> notas = new ArrayList<>();
		try {
			Statement stm = cx.createStatement();
			ResultSet rs = stm.executeQuery("SELECT id,name,grade,status FROM Nota");
			while(rs.next()) {
				Nota nota = new Nota();
				nota.setId(rs.getInt("id"));
				nota.setName(rs.getString("name"));
				nota.setGrade(rs.getInt("grade"));
				nota.setStatus(rs.getBoolean("status"));
				notas.add(nota);
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notas;
	}

	@Override
	public Nota getById(int id) {
		// TODO Auto-generated method stub
		Nota nota = new Nota();
		
		try {
			String query = "SELECT * FROM Nota WHERE id ='"+id+"'";
			PreparedStatement ps = cx.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				nota.setId(rs.getInt("id"));
				nota.setName(rs.getString("name"));
				nota.setGrade(rs.getInt("grade"));
				nota.setStatus(rs.getBoolean("status"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nota;
	}

}
