package controller;

import model.Aluno;
import service.AlunoServices;
import view.ConsultaView;

import javax.swing.*;

public class ConsultaController {
    private final ConsultaView view;
    private final AlunoServices alunoService;

    public ConsultaController(ConsultaView view, AlunoServices alunoService) {
        this.view = view;
        this.alunoService = alunoService;
        view.getBtnConsultar().addActionListener(e -> consultar());
        view.getBtnCancelar().addActionListener(e -> view.dispose());
    }

    private void consultar() {
        try {
            Aluno aluno = alunoService.consultaAluno(view.getTxtMatricula().getText().trim());
            view.getTxtResultado().setText("Matrícula: " + aluno.getMatricula()
                    + "\nNome: " + aluno.getNome()
                    + "\nE-mail: " + aluno.getEmail()
                    + "\nCurso: " + aluno.getCurso().getNomeCurso()
                    + "\nAno de ingresso: " + aluno.getAnoIngresso()
                    + "\nSituação: " + aluno.getSituacao());
        } catch (IllegalArgumentException ex) {
            view.getTxtResultado().setText("");
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Consulta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
