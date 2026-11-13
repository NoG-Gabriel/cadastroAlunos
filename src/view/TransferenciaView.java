package view;

import javax.swing.*;

public class TransferenciaView extends BaseView {

    private JTextField txtMatricula;

    private JComboBox<String> cbNovoCurso;

    private JButton btnTransferir;
    private JButton btnCancelar;

    public TransferenciaView() {

        super("Transferência de Curso", "Alterar curso do aluno");

        txtMatricula = adicionarCampo("Matrícula:");

        cbNovoCurso = adicionarCombo(
            "Novo curso:",
            "Análise e Desenvolvimento de Sistemas",
            "Administração",
            "Logística"
        );

        btnCancelar = adicionarBotao("Cancelar");
        btnTransferir = adicionarBotao("Transferir");
    }

    public JTextField getTxtMatricula() {
        return txtMatricula;
    }

    public JComboBox<String> getCbNovoCurso() {
        return cbNovoCurso;
    }

    public JButton getBtnTransferir() {
        return btnTransferir;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
