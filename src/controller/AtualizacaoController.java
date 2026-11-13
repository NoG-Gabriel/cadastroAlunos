package controller;

import model.Aluno;
import model.Curso;
import service.AlunoServices;
import service.CursoService;
import view.AtualizacaoView;

import javax.swing.*;

public class AtualizacaoController {
    private final AtualizacaoView view;
    private final AlunoServices alunoService;
    private final CursoService cursoService;
    private Aluno alunoEncontrado;

    public AtualizacaoController(AtualizacaoView view, AlunoServices alunoService, CursoService cursoService) {
        this.view = view;
        this.alunoService = alunoService;
        this.cursoService = cursoService;
        
        view.getBtnBuscar().addActionListener(e -> buscar());
        view.getBtnAtualizar().addActionListener(e -> atualizar());
        view.getBtnCancelar().addActionListener(e -> view.dispose());
    }

    private void buscar() {
        try {
            alunoEncontrado = alunoService.consultaAluno(view.getTxtMatricula().getText().trim());
            view.getTxtMatricula().setEnabled(false);
            view.getTxtNome().setText(alunoEncontrado.getNome());
            view.getTxtEmail().setText(alunoEncontrado.getEmail());
            
            view.getTxtAnoIngresso().setText(String.valueOf(alunoEncontrado.getAnoIngresso()));
            view.getCbCurso().setSelectedIndex(alunoEncontrado.getCurso().getId() - 1);
            
            view.getTxtNome().setEnabled(true);
            view.getTxtEmail().setEnabled(true);
            view.getTxtAnoIngresso().setEnabled(true);
            view.getCbCurso().setEnabled(true);
            view.getBtnAtualizar().setEnabled(true);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizar() {
        if (alunoEncontrado == null) return;
        try {
            String matricula = alunoEncontrado.getMatricula();
            String nome = view.getTxtNome().getText().trim();
            String email = view.getTxtEmail().getText().trim();
            
            int ano = Integer.parseInt(view.getTxtAnoIngresso().getText().trim());
            Curso curso = cursoService.encontrarCurso(view.getCbCurso().getSelectedIndex() + 1);
            Aluno alunoAtualizado = new Aluno(matricula, nome, email, curso, ano);
            
            alunoAtualizado.setSituacao(alunoEncontrado.getSituacao());
            alunoService.atualizarAluno(alunoAtualizado);
            JOptionPane.showMessageDialog(view, "Dados do aluno atualizados com sucesso!");
            
            view.dispose();
        } 
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Informe um ano de ingresso válido.", "Dados inválidos", JOptionPane.ERROR_MESSAGE);
        } 
        catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Não foi possível atualizar", JOptionPane.ERROR_MESSAGE);
        }
    }
}
