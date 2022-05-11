package br.unisantos.financas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisantos.financas.model.Categoria;
import br.unisantos.financas.repository.CategoriaRepository;

@Service
public class CategoriaService implements ServiceInterface<Categoria> {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public Categoria create(Categoria obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<Categoria> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Categoria obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
