
package view;

import javax.swing.*;

public class CadastroView extends BaseView {

    private JTextField txtMatricula;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtAnoIngresso;

    private JComboBox<String> cbCurso;

    private JButton btnCadastrar;
    private JButton btnCancelar;

    public CadastroView() {

        super("Cadastro de Aluno", "Cadastrar novo aluno");

        txtMatricula = adicionarCampo("Matrícula:");
        txtNome = adicionarCampo("Nome:");
        txtEmail = adicionarCampo("E-mail:");
        txtAnoIngresso = adicionarCampo("Ano de ingresso:");

        cbCurso = adicionarCombo("Curso:", "Análise e Desenvolvimento de Sistemas", "Administração", "Logística");

        btnCancelar = adicionarBotao("Cancelar");
        btnCadastrar = adicionarBotao("Cadastrar");
    }

    public JTextField getTxtMatricula() {
        return txtMatricula;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtAnoIngresso() {
        return txtAnoIngresso;
    }

    public JComboBox<String> getCbCurso() {
        return cbCurso;
    }

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
