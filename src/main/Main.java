package main;

import repository.*;
import service.*;
import model.*;
import enums.Situacao;

public class Main {

	public static void main(String[] args) {
		// Inicializando
		AlunoRepository alunoRepository = new AlunoRepository(); // Repository Aluno
		CursoRepository cursoRepository = new CursoRepository(); // Repository Curso

		CursoService cursoService = new CursoService(cursoRepository);
		AlunoServices alunoService = new AlunoServices(alunoRepository, cursoService);
		
		
	}

}
