package br.com.bot.uncisal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "alternativa")
public class Alternativa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String descricao;
	
	
	public Alternativa(int id) {
		super();
		this.id = id;
	}

	public Alternativa(int i, String descricao) {
		super();
		this.id = i;
		this.descricao = descricao;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Alternativa [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
}
