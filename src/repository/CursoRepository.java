package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.*;

public class CursoRepository {

	private Map<Integer, Curso> cursos = new HashMap<>();
	
	// Cadastra cursos
	public void salvarCurso(Curso curso) {
		cursos.put(curso.getId(), curso);
	}
	
	// Verificar se curso existe
    public boolean existeCurso(int id) {
    	return cursos.containsKey(id);
    }

    // Buscar curso
    public Curso buscarPorId(int id) {
        return cursos.get(id); // retornar null caso nao ache
    }

    // Listar todos os cursos
    public List<Curso> listarTodos() {
        return new ArrayList<>(cursos.values());
    }

    // Remover curso
    public void removerCurso(int id) {
    	cursos.remove(id);
    }
	
}
