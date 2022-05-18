package br.unisantos.financas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisantos.financas.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
	List<Conta> listarPorAgencia(Integer numeroAgencia);
	List<Conta> listarPorNomeCliente(String nome);
}
