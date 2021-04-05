package com.andresorlando.tienda.prueba.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andresorlando.tienda.prueba.apirest.models.dao.IProductoDao;
import com.andresorlando.tienda.prueba.apirest.models.entity.Producto;


@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	@Transactional
	public List<Producto> findAll() {
		
		return (List<Producto>) productoDao.findAll() ;
	}

	@Override
	@Transactional
	public Producto findById(Long id) {

		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		productoDao.deleteById(id);
	}

}
