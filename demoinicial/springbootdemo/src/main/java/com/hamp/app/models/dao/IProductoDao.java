package com.hamp.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamp.app.models.entity.Producto;

@Repository
public interface IProductoDao extends JpaRepository<Producto, Long>  {

	
}
