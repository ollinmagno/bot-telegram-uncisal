package br.com.bot.uncisal.model;

public class Pergunta {
	private String nome;
	private Alternativa[] alternativas;
	private Alternativa alternativaCorreta;

	public Pergunta(String nome, Alternativa[] alternativas, Alternativa alternativaCorreta) {
		super();
		this.nome = nome;
		this.alternativas = alternativas;
		this.alternativaCorreta = alternativaCorreta;
	}

	public boolean verificarRespostaCorreta(Alternativa alternativa) {
		if (alternativa.getId() == this.alternativaCorreta.getId()) {
			System.out.println("Acertou");
			return true;
		}

		System.out.println("Errou");
		return false;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Alternativa[] getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Alternativa[] alternativas) {
		this.alternativas = alternativas;
	}

	public Alternativa getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(Alternativa alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}

	public String getPerguntaString() {
		String str = this.nome;
		for (int i = 0; i < alternativas.length; i++) {
			Alternativa alternativa = alternativas[i];
			char letra = ' ';
			switch (i) {
			case 0:
				letra = 'a';
				break;
			case 1:
				letra = 'b';
				break;
			case 2:
				letra = 'c';
				break;
			case 3:
				letra = 'd';
				break;
			case 4:
				letra = 'e';
				break;
			default:

			}
		str += "\n" + letra + ") " + alternativa.getDescricao();
 		}
		
		return str;

	}
}
