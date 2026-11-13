package view;

import javax.swing.*;

public class SituacaoView extends BaseView {

    private JTextField txtMatricula;

    private JButton btnTrancar;
    private JButton btnAtivar;
    private JButton btnCancelar;

    public SituacaoView() {

        super("Situação do Aluno", "Gerenciar situação acadêmica");

        txtMatricula = adicionarCampo("Matrícula:");

        btnCancelar = adicionarBotao("Cancelar");
        btnTrancar = adicionarBotao("Trancar aluno");
        btnAtivar = adicionarBotao("Ativar aluno");
    }

    public JTextField getTxtMatricula() {
        return txtMatricula;
    }

    public JButton getBtnTrancar() {
        return btnTrancar;
    }

    public JButton getBtnAtivar() {
        return btnAtivar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
