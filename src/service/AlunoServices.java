package service;

import repository.AlunoRepository;

import java.time.Year;
import java.util.List;

import enums.Situacao;
import model.*;

public class AlunoServices {
	
	private AlunoRepository repository;

	public AlunoServices(AlunoRepository repository) {
		this.repository = repository;
	}
	
	// Cadastrar aluno
	public void cadastrarAluno(Aluno aluno) {

		validarMatricula(aluno.getMatricula());
		validarNome(aluno.getNome());
		validarEmail(aluno.getEmail());
		validarCurso(aluno.getCurso());
		validarAnoIngresso(aluno.getAnoIngresso());

		repository.salvarAluno(aluno);
	}
	
	// Atualizar Aluno
	public void atualizarAluno(Aluno aluno) {

		// Verificar existencia de matricula
		if (repository.existeMatricula(aluno.getMatricula())) {
			checarSituacao(aluno.getSituacao());
			validarNome(aluno.getNome());
			validarEmail(aluno.getEmail());
			validarCurso(aluno.getCurso());
			validarAnoIngresso(aluno.getAnoIngresso());
			
			repository.salvarAluno(aluno);
		}
		else {
			throw new IllegalArgumentException("Matrícula não encontrada!");
		}

	}
	
	// Consultar aluno
	public Aluno consultaAluno(String matricula) {
		if (repository.existeMatricula(matricula)) {
			return repository.buscarPorMatricula(matricula); // Retorna um aluno
		}
		
		throw new IllegalArgumentException("Matrícula não encontrada!");
	}
	
	
	// Listar todos os alunos
	public List<Aluno> listarAlunos(){
		return repository.listarTodos();
	}
	
	// Excluir aluno / Trocar situacao para trancado
	public void trancarCurso(String matricula) {
		Aluno aluno = new Aluno();
		if (repository.existeMatricula(matricula)) {
			aluno = repository.buscarPorMatricula(matricula); // Buscando aluno
			aluno.setSituacao(Situacao.TRANCADO); // Mudando Situacao
			repository.salvarAluno(aluno); // Atualiza por key ja existir
		}
		else {
			throw new IllegalArgumentException("Matrícula não encontrada!");
		}
	}
	
	// Ativar curso trancado do aluno
	public void ativarCurso(String matricula) {
		Aluno aluno = new Aluno();
		if (repository.existeMatricula(matricula)) {
			aluno = repository.buscarPorMatricula(matricula); // Buscando aluno
			aluno.setSituacao(Situacao.ATIVO); // Mudando Situacao
			repository.salvarAluno(aluno); // Atualiza por key ja existir
		}
		else {
			throw new IllegalArgumentException("Matrícula não encontrada!");
		}
	}
	
	// Remover aluno
	public void removerAluno(String matricula) {
		if(repository.existeMatricula(matricula)) {
			repository.removerAluno(matricula); // Apaga do hashmap
		}
		else {
			throw new IllegalArgumentException("Matrícula não encontrada!");
		}
	}
	
	
	//////////////////////////
	// |METODOS AUXILIARES| //
	//////////////////////////
	
	// Validar matrícula
	private void validarMatricula(String matricula) {

		if (matricula == null || matricula.isBlank()) {
			throw new IllegalArgumentException("A matrícula é obrigatória!");
		}

		if (repository.existeMatricula(matricula)) {
			throw new IllegalArgumentException("Matrícula já cadastrada!");
		}
	}

	// Validar nome
	private void validarNome(String nome) {

		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome é obrigatório!");
		}
	}

	// Validar e-mail
	private void validarEmail(String email) {

		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("O e-mail é obrigatório!");
		}

		if (!email.contains("@")) {
			throw new IllegalArgumentException("O e-mail deve conter @!");
		}
	}

	// Validar curso
	private void validarCurso(Curso curso) {

		if (curso == null) {
			throw new IllegalArgumentException("O curso é obrigatório!");
		}

		String nomeCurso = curso.getNomeCurso();

		if (nomeCurso == null || (
				!nomeCurso.equals("Análise e Desenvolvimento de Sistemas") &&
				!nomeCurso.equals("Administração") &&
				!nomeCurso.equals("Logística"))) {

			throw new IllegalArgumentException("Curso inválido!");
		}
	}

	// Validar ano de ingresso
	private void validarAnoIngresso(int anoIngresso) {

		int anoAtual = Year.now().getValue();

		if (anoIngresso < 2000 || anoIngresso > anoAtual) {
			throw new IllegalArgumentException(
					"O ano de ingresso deve estar entre 2000 e " + anoAtual + "!"
					);
		}
	    
	
	}
	
	// Checar situacao do aluno
	private void checarSituacao(Situacao situacao) {
		if (situacao == Situacao.TRANCADO) {
			throw new IllegalArgumentException("O aluno não pode ser alterado!");
		}
	}
	
}
