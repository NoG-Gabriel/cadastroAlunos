package main;

import repository.AlunoRepository;
import model.*;
import enums.Situacao;

public class Main {

	public static void main(String[] args) {
		AlunoRepository repository = new AlunoRepository();
		Professor pro = new Professor();
		pro.setNome("Jonas");
		
		Curso cu = new Curso(12, "ADS");

		Aluno aluno = new Aluno(
		    "000123",
		    "joao@email.com",
		    "João",
		    cu,
		    2026
		);

		repository.salvar(aluno);

		System.out.println(repository.existe("000123"));

		System.out.println(
		    repository.buscarPorMatricula("000123").getNome()
		);
	}

}
