package com.andresorlando.tienda.prueba.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.andresorlando.tienda.prueba.apirest.models.entity.Compra;

public interface ICompraDao extends JpaRepository<Compra, Long>{

	@Modifying
	@Query("update Compra c set c.valor = ?1, c.transporte = ?2 where c.id = ?3")
	int setFixedFirstnameFor(Double valor, Double transporte, Long id);
	
}
