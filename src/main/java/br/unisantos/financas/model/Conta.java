package br.unisantos.financas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_conta")
@NamedQueries({
	@NamedQuery(name = "Conta.listarPorAgencia", 
			    query = "select c from Conta c where c.agencia = ?1"),
	@NamedQuery(name = "Conta.listarPorNomeCliente",
	query = "select c from Conta c join Cliente cc on cc.conta = c where cc.nome like ?1")
})
public class Conta extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nr_agencia")
	private Integer agencia;
	
	@Column(name = "nm_numero", length = 10)
	private String numero;
	
	@Column(name = "vl_saldo")
	private Float saldo;
			
	public Conta() {
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}	
	
}
