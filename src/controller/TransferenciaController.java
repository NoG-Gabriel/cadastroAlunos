package controller;

import service.AlunoServices;
import view.TransferenciaView;

import javax.swing.*;

public class TransferenciaController {
    private final TransferenciaView view;
    private final AlunoServices alunoService;

    public TransferenciaController(TransferenciaView view, AlunoServices alunoService) {
        this.view = view;
        this.alunoService = alunoService;
        view.getBtnTransferir().addActionListener(e -> transferir());
        view.getBtnCancelar().addActionListener(e -> view.dispose());
    }

    private void transferir() {
        try {
            String matricula = view.getTxtMatricula().getText().trim();
            int idCurso = view.getCbNovoCurso().getSelectedIndex() + 1;
            alunoService.atualizarCurso(matricula, idCurso);
            JOptionPane.showMessageDialog(view, "Curso do aluno atualizado com sucesso!");
            view.dispose();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Transferência", JOptionPane.ERROR_MESSAGE);
        }
    }
}
