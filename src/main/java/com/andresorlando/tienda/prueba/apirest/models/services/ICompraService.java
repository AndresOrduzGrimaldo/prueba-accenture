package com.andresorlando.tienda.prueba.apirest.models.services;

import java.util.List;

import com.andresorlando.tienda.prueba.apirest.models.entity.Compra;


public interface ICompraService {

public List<Compra> findAll();
	
	public Compra findById(Long id);
	
	public Compra save(Compra producto);
	
	public void delete(Long id);
}
