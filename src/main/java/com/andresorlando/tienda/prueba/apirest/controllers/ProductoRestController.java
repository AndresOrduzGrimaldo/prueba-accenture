package com.andresorlando.tienda.prueba.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.andresorlando.tienda.prueba.apirest.models.entity.Cliente;
import com.andresorlando.tienda.prueba.apirest.models.entity.Producto;
import com.andresorlando.tienda.prueba.apirest.models.services.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {

	@Autowired
	IProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> index(){
		
		return productoService.findAll();
	}
	
	@GetMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Producto show (@PathVariable  Long id) {
		
		return productoService.findById(id);
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		
		return productoService.save(producto);
	}
	
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoActual = productoService.findById(id);
		
		productoActual.setNombre(producto.getNombre());
		productoActual.setPrecio(producto.getPrecio());
		
		return productoService.save(productoActual);
		
	}
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productoService.delete(id);
	}
	
	
	
	
	
	
}
