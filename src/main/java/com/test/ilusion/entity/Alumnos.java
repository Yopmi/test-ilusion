package com.test.ilusion.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "ALUMNOS", schema = "escuela")
@Data @ToString
public class Alumnos implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9195489789644392297L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idAlumno;
	
	private String nombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	
	private String telefono;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idNivel", insertable = false, updatable = false)
	@JsonIgnore
	private NivelesEducativos niveles;
	
	private String idNivel;

}
