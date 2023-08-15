package main.model.atleta;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Atleta implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private int idade;
	private String escola;
	private TipoDeVolei tipoDeVolei;
	
	public Atleta() {
		super();
	}

	public Atleta(String nome, int idade, String escola, TipoDeVolei tipoDeVolei) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.escola = escola;
		this.tipoDeVolei = tipoDeVolei;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	public TipoDeVolei getTipoDeVolei() {
		return tipoDeVolei;
	}

	public void setTipoDeVolei(TipoDeVolei tipoDeVolei) {
		this.tipoDeVolei = tipoDeVolei;
	}
	
	
}
