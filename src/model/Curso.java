package model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	private int id;
	private String nomeCurso;
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private Professor professor;
	
	public Curso (int id, String nome) {
		this.id = id;
		this.nomeCurso = nome;
	}
	
	/////////////////
	// LISTA ALUNO //
	/////////////////
	/// 
	/// // Adicionar aluno
	public void adicionarAluno(Aluno aluno) {

        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
        }

    }
	///
	/// // Remover aluno
    public void removerAluno(Aluno aluno) {

        alunos.remove(aluno);

    }
	
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
}
