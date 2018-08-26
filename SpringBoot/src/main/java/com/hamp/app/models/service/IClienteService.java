package com.hamp.app.models.service;

import java.util.List;

import com.hamp.app.models.entity.Cliente;

public interface IClienteService{
	public List<Cliente> findAll();
	public void save(Cliente t);
	public Cliente findOne(Long t);
	public void delete(Long t);
}
