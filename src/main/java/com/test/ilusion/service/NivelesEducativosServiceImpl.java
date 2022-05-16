package com.test.ilusion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ilusion.entity.NivelesEducativos;
import com.test.ilusion.repository.NivelesEducativosRepository;

@Service
public class NivelesEducativosServiceImpl implements NivelesEducativosService {
	
	@Autowired
	private NivelesEducativosRepository nivelesEducativosRepository;

	@Override
	public NivelesEducativos save(NivelesEducativos nivelesEducativos) {
		return nivelesEducativosRepository.save(nivelesEducativos);
	}

	@Override
	public NivelesEducativos findById(String idNivel) {
		return nivelesEducativosRepository.findById(idNivel).orElse(null);
	}

	@Override
	public List<NivelesEducativos> findAll() {
		return nivelesEducativosRepository.findAll();
	}

	@Override
	public void deleteById(String idNivel) {
		nivelesEducativosRepository.deleteById(idNivel);
	}

}
