package model;

import enums.Situacao;

public class Aluno {
	
	private String matricula;
	
	private String email;
	private String nome;
	private Curso curso;
	private int anoIngresso;
	
	// Utilizando Enum para facilitar a verificacao de estado
	private Situacao situacao;
	
	public Aluno (String matricula, String nome, String email, Curso curso, int anoIngresso) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.curso = curso;
		this.anoIngresso = anoIngresso;
		this.setSituacao(Situacao.ATIVO);
	}
	
	public Aluno() {
		
	}
	
	
	
	// Getters and Setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
	public int getAnoIngresso() {
		return anoIngresso;
	}

	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}

	
	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

}
