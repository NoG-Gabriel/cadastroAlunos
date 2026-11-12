package repository;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import model.Aluno;

public class AlunoRepository {

    private Map<String, Aluno> alunos = new HashMap<>();

    // Salvar aluno
    public void salvarAluno(Aluno aluno) {
        alunos.put(aluno.getMatricula(), aluno);
    }
    
    // Verificar se matrícula existe
    public boolean existeMatricula(String matricula) {
    	return alunos.containsKey(matricula);
    }

    // Buscar aluno
    public Aluno buscarPorMatricula(String matricula) {
        return alunos.get(matricula); // retornar null caso nao ache
    }

    // Listar todos os alunos
    public List<Aluno> listarTodos() {
        return new ArrayList<>(alunos.values());
    }

    // Remover aluno
    public void removerAluno(String matricula) {
    	alunos.remove(matricula);
    }
    
}
