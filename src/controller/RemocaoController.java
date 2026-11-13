package controller;

import service.AlunoServices;
import view.RemocaoView;

import javax.swing.*;

public class RemocaoController {
    private final RemocaoView view;
    private final AlunoServices alunoService;

    public RemocaoController(RemocaoView view, AlunoServices alunoService) {
        this.view = view;
        this.alunoService = alunoService;
        view.getBtnRemover().addActionListener(e -> remover());
        view.getBtnCancelar().addActionListener(e -> view.dispose());
    }

    private void remover() {
        int confirmacao = JOptionPane.showConfirmDialog(view,
                "Deseja realmente excluir o aluno de matrícula " + view.getTxtMatricula().getText().trim() + "?",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirmacao != JOptionPane.YES_OPTION) return;

        try {
            alunoService.removerAluno(view.getTxtMatricula().getText().trim());
            JOptionPane.showMessageDialog(view, "Aluno removido com sucesso!");
            view.dispose();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Remoção", JOptionPane.ERROR_MESSAGE);
        }
    }
}
