package br.unisantos.financas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisantos.financas.model.Movimentacao;
import br.unisantos.financas.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService implements ServiceInterface<Movimentacao> {

	@Autowired
	private MovimentacaoRepository repository;

	@Override
	public Movimentacao create(Movimentacao obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Movimentacao findById(Long id) {
		Optional<Movimentacao> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<Movimentacao> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Movimentacao obj) {
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
