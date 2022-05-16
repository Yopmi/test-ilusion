package com.test.ilusion.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "NIVELES_EDUCATIVOS", schema = "escuela")
@Data
public class NivelesEducativos implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4097414686538649944L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idNivel;
	
	private String descripcion;	

}
