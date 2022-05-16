package com.test.ilusion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.test.ilusion.entity.NivelesEducativos;
import com.test.ilusion.service.NivelesEducativosService;

@RestController
@RequestMapping("niveles")
@CrossOrigin(origins = "*")
public class NivelesEducativosController {
	
	@Autowired
	private NivelesEducativosService nivelesEducativosService;
	
	@GetMapping
	public ResponseEntity<?> getNivelesEducativos(@RequestParam(required = false) String idNivel){
		try {
			if(idNivel == null) {
				return new ResponseEntity<List<NivelesEducativos>>(nivelesEducativosService.findAll(),HttpStatus.OK);
			}else {
				return new ResponseEntity<NivelesEducativos>(nivelesEducativosService.findById(idNivel),HttpStatus.OK);
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Algo salio mal al obtener niveles");
		}
	}
	
	@DeleteMapping("{idNivel}")
	public ResponseEntity<?> deleteNivelesEducativos(@PathVariable String idNivel){
		try {
			nivelesEducativosService.deleteById(idNivel);
			return new ResponseEntity<String>("Eliminado xon exito", HttpStatus.OK);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Algo salio mal al eliminar nivel");
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateNivelesEducativos(@RequestBody NivelesEducativos nivelesEducativos){
		try {
			NivelesEducativos nivelesEducativosBD = nivelesEducativosService.findById(nivelesEducativos.getIdNivel());				
			if(nivelesEducativosBD == null) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, "Algo salio mal el nivel a actualizar no existe");
			}else {
				nivelesEducativosBD.setDescripcion(nivelesEducativos.getDescripcion());
				return new ResponseEntity<NivelesEducativos>(nivelesEducativosService.save(nivelesEducativosBD), HttpStatus.OK);
			}
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Algo salio mal al eliminar nivel");
		}
	}
}