package com.test.ilusion.service;

import java.util.List;

import com.test.ilusion.entity.NivelesEducativos;

public interface NivelesEducativosService {
	
	NivelesEducativos save(NivelesEducativos nivelesEducativos);
	
	NivelesEducativos findById(String idNivel);
	
	void deleteById(String idNivel);
	
	List<NivelesEducativos> findAll();

}
