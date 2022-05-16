package com.test.ilusion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.test.ilusion.entity.Alumnos;
import com.test.ilusion.service.AlumnosService;

@RestController
@RequestMapping("alumnos")
@CrossOrigin(origins = "*")
public class AlumnosController {
	
	@Autowired
	private AlumnosService alumnosService;
	
	@GetMapping
	public ResponseEntity<?> getAlumnos(@RequestParam(required = false) Long idAlumnos){
		try {
			if(idAlumnos == null) {
				return new ResponseEntity<List<Alumnos>>(alumnosService.findAll(),HttpStatus.OK);
			}else {
				return new ResponseEntity<Alumnos>(alumnosService.findById(idAlumnos),HttpStatus.OK);
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Algo salio mal al obtener alumnos");
		}
	}
	
	@PostMapping
	public ResponseEntity<?> saveAlumnos(@RequestBody Alumnos alumnos){
		try {
			return new ResponseEntity<Alumnos>(alumnosService.save(alumnos), HttpStatus.OK);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Algo salio mal al guardar alumno");
		}		
	}
	
	@DeleteMapping("{idAlumnos}")
	public ResponseEntity<?> deleteAlumnos(@PathVariable Long idAlumnos){
		try {
			alumnosService.deleteById(idAlumnos);
			return new ResponseEntity<String>("Eliminado con exito", HttpStatus.OK);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Algo salio mal al eliminar alumno");
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateAlumnos(@RequestBody Alumnos alumnos){
		try {
			Alumnos alumnosBD = alumnosService.findById(alumnos.getIdAlumno());				
			if(alumnosBD == null) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, "Algo salio mal el alumno a actualizar no existe");
			}else {
				alumnosBD.setTelefono(alumnos.getTelefono());
				alumnosBD.setIdNivel(alumnos.getIdNivel());
				return new ResponseEntity<Alumnos>(alumnosService.save(alumnosBD), HttpStatus.OK);
			}
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Algo salio mal al eliminar alumno");
		}
	}
}