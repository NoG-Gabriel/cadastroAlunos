package controller;

import service.AlunoServices;
import view.SituacaoView;

import javax.swing.*;

public class SituacaoController {
    private final SituacaoView view;
    private final AlunoServices alunoService;

    public SituacaoController(SituacaoView view, AlunoServices alunoService) {
        this.view = view;
        this.alunoService = alunoService;
        view.getBtnTrancar().addActionListener(e -> alterarSituacao(true));
        view.getBtnAtivar().addActionListener(e -> alterarSituacao(false));
        view.getBtnCancelar().addActionListener(e -> view.dispose());
    }

    private void alterarSituacao(boolean trancar) {
        try {
            String matricula = view.getTxtMatricula().getText().trim();
            if (trancar) {
            	alunoService.trancarCurso(matricula);
            }
            else {
            	alunoService.ativarCurso(matricula);
            }
            JOptionPane.showMessageDialog(view, trancar ? "Aluno trancado com sucesso!" : "Aluno ativado com sucesso!");
            view.dispose();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Situação do aluno", JOptionPane.ERROR_MESSAGE);
        }
    }
}
