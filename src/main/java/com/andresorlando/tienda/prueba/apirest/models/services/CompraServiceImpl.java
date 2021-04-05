package com.andresorlando.tienda.prueba.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andresorlando.tienda.prueba.apirest.models.dao.ICompraDao;
import com.andresorlando.tienda.prueba.apirest.models.entity.Compra;
import com.andresorlando.tienda.prueba.apirest.models.entity.Producto;

@Service
public class CompraServiceImpl implements ICompraService{

	@Autowired
	private ICompraDao compraDao;
	
	@Override
	@Transactional
	public List<Compra> findAll() {
		
		return (List<Compra>) compraDao.findAll();
	}

	@Override
	@Transactional
	public Compra findById(Long id) {
		
		return compraDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Compra save(Compra compra) {
		
		compraConDomicilio(compra);
		
		aplicarIva(compra, 0.10);
		
		return compraDao.save(compra);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		compraDao.deleteById(id);
	}
	
	
	private void compraConDomicilio(Compra compra) {
		
		List<Producto> productos = compra.getProductos();
		
		Double totalCompra = 0D;
		
		for (Producto producto : productos) {
			totalCompra += producto.getPrecio();
		}
		
		if(totalCompra <= 100000.0) {
			compra.setTransporte(10000.0);
		}else {
			compra.setTransporte(0.0);
		}
	}
	
	private void aplicarIva(Compra compra, double iva) {
		
		double valorBase = compra.getValor();
		compra.setValor(valorBase*=iva);
	}

}
