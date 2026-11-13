package model;

public class Professor {
	
	private String nome;
	private Curso cursoResponsavel;
	
	public Professor(String nome, Curso cursoResponsavel) {
		this.nome = nome;
		this.cursoResponsavel = cursoResponsavel;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Curso getCursoResponsavel() {
		return cursoResponsavel;
	}
	public void setCursoResponsavel(Curso cursoResponsavel) {
		this.cursoResponsavel = cursoResponsavel;
	}
	
}
