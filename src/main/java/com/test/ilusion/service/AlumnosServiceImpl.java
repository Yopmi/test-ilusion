package com.test.ilusion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ilusion.entity.Alumnos;
import com.test.ilusion.repository.AlumnosRepository;

@Service
public class AlumnosServiceImpl implements AlumnosService {
	
	@Autowired
	private AlumnosRepository alumnosRepository;

	@Override
	public Alumnos save(Alumnos alumno) {
		return alumnosRepository.save(alumno);
	}

	@Override
	public Alumnos findById(Long idAlumno) {
		return alumnosRepository.findById(idAlumno).orElse(null);
	}

	@Override
	public List<Alumnos> findAll() {
		return alumnosRepository.findAll();
	}

	@Override
	public void deleteById(Long idAlumno) {
		alumnosRepository.deleteById(idAlumno);
	}

}
