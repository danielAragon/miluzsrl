package com.hamp.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamp.app.models.dao.IRutaDAO;
import com.hamp.app.models.entity.Ruta;

@Service
public class RutaService implements IRutaService {

	@Autowired
	IRutaDAO rutaDAO;
	
	@Override
	public List<Ruta> findAll() {
		// TODO Auto-generated method stub
		return (List<Ruta>)rutaDAO.findAll();
	}

	@Override
	public void save(Ruta t) {
		// TODO Auto-generated method stub
		rutaDAO.save(t);
	}

	@Override
	public Ruta findOne(String t) {
		// TODO Auto-generated method stub
		return (Ruta)rutaDAO.findOne(t);
	}

	@Override
	public void delete(String t) {
		// TODO Auto-generated method stub
		rutaDAO.delete(t);
	}

}
