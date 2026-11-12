package repository;

import java.util.HashMap;
import java.util.Map;

import model.*;

public class CursoRepository {

	private Map<Integer, Curso> cursos = new HashMap<>();
	
	// Cadastra cursos
	public void salvarCurso(Curso curso) {
		cursos.put(curso.getId(), curso);
	}
	
	
}
