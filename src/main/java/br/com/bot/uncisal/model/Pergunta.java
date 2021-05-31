package br.com.bot.uncisal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pergunta")
public class Pergunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "nome")
	private String nome;
	
	@OneToMany()
	private List<Alternativa> alternativas;
//	private Map<String, List<Alternativa>> alternativas = new HashMap<String, List<Alternativa>>();
	
	
	
	
	public Pergunta(long id, String nome, List<Alternativa> alternativas) {
		super();
		this.id = id;
		this.nome = nome;
		this.alternativas = alternativas;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Alternativa> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
	
	
	
	
	
	
	
	

	

//	public String getPerguntaString() {
//		String str = this.nome;
//		for (int i = 0; i < alternativas.length; i++) {
//			Alternativa alternativa = alternativas[i];
//			char letra = ' ';
//			switch (i) {
//			case 0:
//				letra = 'a';
//				break;
//			case 1:
//				letra = 'b';
//				break;
//			case 2:
//				letra = 'c';
//				break;
//			case 3:
//				letra = 'd';
//				break;
//			case 4:
//				letra = 'e';
//				break;
//			default:
//
//			}
//		str += "\n" + letra + ") " + alternativa.getDescricao();
// 		}
//		
//		return str;
//
//	}
}
