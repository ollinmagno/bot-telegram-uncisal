package br.com.bot.uncisal.model;

public class Alternativa {
	private int id;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
