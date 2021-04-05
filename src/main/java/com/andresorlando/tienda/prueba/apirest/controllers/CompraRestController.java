package com.andresorlando.tienda.prueba.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.andresorlando.tienda.prueba.apirest.models.entity.Compra;
import com.andresorlando.tienda.prueba.apirest.models.services.ICompraService;

@RestController
@RequestMapping("/compras")
public class CompraRestController{
	
	@Autowired
	private ICompraService compraService;

	@GetMapping("/compras")
	public List<Compra> index(){
		
		return compraService.findAll();
	}
	
	@GetMapping("/compras/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Compra show(@PathVariable Long id) {
		
		return compraService.findById(id);
	}
	
	@PostMapping("/compras")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra create(@RequestBody Compra compra) {
		
//		cliente.setCreateAt(new Date());
		return compraService.save(compra);
	}
	
	@PutMapping("/compras/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra update(@RequestBody Compra compra, @PathVariable Long id) {
		Compra compraActual = compraService.findById(id);
		
		compraActual.setProductos(compra.getProductos());
		compraActual.setTransporte(compra.getTransporte());
		compraActual.setValor(compra.getValor());
		
		return compraService.save(compraActual);
		
	}
	
	@DeleteMapping("/compras/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		compraService.delete(id);
	}
}
