package repository;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import model.Aluno;

public class AlunoRepository {

    private Map<String, Aluno> alunos = new HashMap<>();

    // Salvar aluno
    public boolean salvar(Aluno aluno) {
        return alunos.putIfAbsent(aluno.getMatricula(), aluno) == null;
    }

    // Verificar se matrícula existe
    public boolean existe(String matricula) {
    	return alunos.containsKey(matricula);
    }

    // Buscar aluno
    public Aluno buscarPorMatricula(String matricula) {
        return alunos.get(matricula);
    }

    // Listar todos os alunos
    public List<Aluno> listarTodos() {
        return new ArrayList<>(alunos.values());
    }

    
}
