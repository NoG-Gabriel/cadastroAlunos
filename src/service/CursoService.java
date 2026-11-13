package service;

import model.Curso;
import repository.CursoRepository;

public class CursoService {
	
	private final CursoRepository repository;
	
	public CursoService(CursoRepository repository) {
        this.repository = repository;
    }
	
	// Encontrar curso - Devolve a classe curso para conseguir obter a lista alunos
	public Curso encontrarCurso(int id) {
		if(repository.existeCurso(id)) {
			return repository.buscarPorId(id);
		}
		else {
			throw new IllegalArgumentException("Curso não existente!");
		}
	}
	
	
}
