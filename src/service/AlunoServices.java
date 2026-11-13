package service;

import repository.AlunoRepository;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import enums.Situacao;
import model.*;

public class AlunoServices {	

	private final AlunoRepository repository;
	private final CursoService cursoService;

	public AlunoServices(AlunoRepository repository, CursoService cursoService) {
	    this.repository = repository;
	    this.cursoService = cursoService;
	}
	
	// Cadastrar aluno
	public void cadastrarAluno(Aluno aluno) {

		// Validacao
		validarMatricula(aluno.getMatricula());
		validarNome(aluno.getNome());
		validarEmail(aluno.getEmail());
		validarCurso(aluno.getCurso());
		validarAnoIngresso(aluno.getAnoIngresso());

		// Encontrando curso inserido
		Curso curso = cursoService.encontrarCurso(aluno.getCurso().getId());
		
		// Sincronizando armazenamento
		aluno.setCurso(curso);
	    curso.adicionarAluno(aluno);
	    
		// Salvar no repository
		repository.salvarAluno(aluno);
	}
	
	// Atualizar Aluno
	public void atualizarAluno(Aluno aluno) {

		// Verificar existencia de matricula
		if (repository.existeMatricula(aluno.getMatricula())) {
			validarNome(aluno.getNome());
			validarEmail(aluno.getEmail());
			validarCurso(aluno.getCurso());
			validarAnoIngresso(aluno.getAnoIngresso());
			
			// Encontrando o aluno e o curso atual para manter as listas sincronizadas
			Aluno alunoAtual = repository.buscarPorMatricula(aluno.getMatricula());
			Curso cursoAnterior = alunoAtual.getCurso();
			Curso cursoNovo = cursoService.encontrarCurso(aluno.getCurso().getId());
			
			if (cursoAnterior != null) {
				cursoAnterior.removerAluno(alunoAtual);
			}
			aluno.setCurso(cursoNovo);
			cursoNovo.adicionarAluno(aluno);
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

	public List<Aluno> listarAlunosPorCurso(int idCurso) {
		Curso curso = cursoService.encontrarCurso(idCurso);
		return new ArrayList<>(curso.getAlunos());
	}
	
	// Excluir aluno / Trocar situacao para trancado
	public void trancarCurso(String matricula) {
		if (repository.existeMatricula(matricula)) {
			Aluno aluno = repository.buscarPorMatricula(matricula);
			if (aluno.getSituacao() != Situacao.ATIVO) {
				throw new IllegalArgumentException("Somente alunos ativos podem ser trancados!");
			}
			aluno.setSituacao(Situacao.TRANCADO);
			repository.salvarAluno(aluno);
		}
		else {
			throw new IllegalArgumentException("Matrícula não encontrada!");
		}
	}
	
	// Ativar curso trancado do aluno
	public void ativarCurso(String matricula) {
		if (repository.existeMatricula(matricula)) {
			Aluno aluno = repository.buscarPorMatricula(matricula);
			if (aluno.getSituacao() != Situacao.TRANCADO) {
				throw new IllegalArgumentException("Somente alunos trancados podem ser reativados!");
			}
			aluno.setSituacao(Situacao.ATIVO);
			repository.salvarAluno(aluno);
		}
		else {
			throw new IllegalArgumentException("Matrícula não encontrada!");
		}
	}
	
	// Atualizando Curso
	public void atualizarCurso(String matricula, int idNovoCurso) {

	    // Buscar aluno
	    Aluno aluno = consultaAluno(matricula);
	    checarSituacao(aluno.getSituacao());
	    
	    Curso novoCurso = cursoService.encontrarCurso(idNovoCurso);
	    Curso cursoAtual = aluno.getCurso();
	    
	    // Verifica se ele esta sendo alterado pro mesmo curso
	    if (cursoAtual.getId() == novoCurso.getId()) {
	        throw new IllegalArgumentException("O aluno já pertence a este curso!");
	    }
	
	    cursoAtual.removerAluno(aluno); // Removendo
	    aluno.setCurso(novoCurso); // Salvando no novo curso
	    novoCurso.adicionarAluno(aluno); // Adicionando aluno dentro do curso

	}
	
	//  Remover aluno - Map e lista
	public void removerAluno(String matricula) {

		if(repository.existeMatricula(matricula)) {
			
		    Aluno aluno = consultaAluno(matricula);
		    Curso curso = aluno.getCurso();
		    
		    // Remover aluno da lista do curso
		    curso.removerAluno(aluno);

		    // Remover aluno do repository
		    repository.removerAluno(matricula);
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
