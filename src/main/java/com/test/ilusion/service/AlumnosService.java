package com.test.ilusion.service;

import java.util.List;

import com.test.ilusion.entity.Alumnos;

public interface AlumnosService {
	
	Alumnos save(Alumnos alumno);
	
	Alumnos findById(Long idAlumno);
	
	void deleteById(Long idAlumno);
	
	List<Alumnos> findAll();

}
