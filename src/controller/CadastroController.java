package controller;

import model.Aluno;
import model.Curso;
import service.AlunoServices;
import service.CursoService;
import view.CadastroView;

import javax.swing.*;

public class CadastroController {
    private final CadastroView view;
    private final AlunoServices alunoService;
    private final CursoService cursoService;

    public CadastroController(CadastroView view, AlunoServices alunoService, CursoService cursoService) {
        this.view = view;
        this.alunoService = alunoService;
        this.cursoService = cursoService;
        view.getBtnCadastrar().addActionListener(e -> cadastrar());
        view.getBtnCancelar().addActionListener(e -> view.dispose());
    }

    private void cadastrar() {
        try {
            String matricula = view.getTxtMatricula().getText().trim();
            String nome = view.getTxtNome().getText().trim();
            String email = view.getTxtEmail().getText().trim();
            int ano = Integer.parseInt(view.getTxtAnoIngresso().getText().trim());
            Curso curso = cursoService.encontrarCurso(view.getCbCurso().getSelectedIndex() + 1);
            alunoService.cadastrarAluno(new Aluno(matricula, nome, email, curso, ano));
            JOptionPane.showMessageDialog(view, "Aluno cadastrado com sucesso!");
            view.dispose();
        } catch (NumberFormatException ex) {
            erro("Informe um ano de ingresso válido.");
        } catch (IllegalArgumentException ex) {
            erro(ex.getMessage());
        }
    }

    private void erro(String mensagem) {
        JOptionPane.showMessageDialog(view, mensagem, "Não foi possível cadastrar", JOptionPane.ERROR_MESSAGE);
    }
}
