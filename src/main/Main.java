package main;

import repository.*;
import service.*;
import view.*;
import controller.HomeController;
import model.*;


public class Main {

	public static void main(String[] args) {
		// Inicializando repositorios
		///
		AlunoRepository alunoRepository = new AlunoRepository(); // Repository Aluno
		CursoRepository cursoRepository = new CursoRepository(); // Repository Curso

		CursoService cursoService = new CursoService(cursoRepository);
		AlunoServices alunoService = new AlunoServices(alunoRepository, cursoService);

		// Inicializando cursos
		Curso ads = new Curso(1, "Análise e Desenvolvimento de Sistemas");
		Curso adm = new Curso(2, "Administração");
		Curso log = new Curso(3, "Logística");
		
		// Inicializando professores
		Professor p1 = new Professor("Juliano Carvalho", ads);
		Professor p2 = new Professor("Thiago Nogueira", adm);
		Professor p3 = new Professor("Cecilia Alves", log);
		
		ads.setProfessor(p1);
		adm.setProfessor(p2);
		log.setProfessor(p3);
		
		// Armazenando em repositorio
		cursoRepository.salvarCurso(ads);
		cursoRepository.salvarCurso(adm);
		cursoRepository.salvarCurso(log);
		
		/////////////////////////////////////////////////////
		
		// View 
		HomeView home = new HomeView();
		HomeController controller = new HomeController(home, alunoService, cursoService);
	    home.setVisible(true);
	    
	}

}
