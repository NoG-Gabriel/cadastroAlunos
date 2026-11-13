package view;

import javax.swing.*;

public class RemocaoView extends BaseView {

    private JTextField txtMatricula;

    private JButton btnRemover;
    private JButton btnCancelar;

    public RemocaoView() {

        super("Remoção de Aluno", "Remover aluno do sistema");

        txtMatricula = adicionarCampo("Matrícula:");

        btnCancelar = adicionarBotao("Cancelar");
        btnRemover = adicionarBotao("Remover aluno");
    }

    public JTextField getTxtMatricula() {
        return txtMatricula;
    }

    public JButton getBtnRemover() {
        return btnRemover;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
