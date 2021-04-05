package com.andresorlando.tienda.prueba.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andresorlando.tienda.prueba.apirest.models.entity.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long>{

}
