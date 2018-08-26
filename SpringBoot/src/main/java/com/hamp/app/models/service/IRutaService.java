package com.hamp.app.models.service;

import java.util.List;

import com.hamp.app.models.entity.Ruta;

public interface IRutaService {
	public List<Ruta> findAll();
	public void save(Ruta t);
	public Ruta findOne(String t);
	public void delete(String t);
}
