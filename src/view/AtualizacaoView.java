
package view;

import javax.swing.*;

public class AtualizacaoView extends BaseView {

    private JTextField txtMatricula;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtAnoIngresso;

    private JComboBox<String> cbCurso;

    private JButton btnBuscar;
    private JButton btnAtualizar;
    private JButton btnCancelar;

    public AtualizacaoView() {

        super("Atualização de Aluno", "Atualizar dados cadastrais");

        txtMatricula = adicionarCampo("Matrícula:");
        txtNome = adicionarCampo("Nome:");
        txtEmail = adicionarCampo("E-mail:");
        txtAnoIngresso = adicionarCampo("Ano de ingresso:");

        cbCurso = adicionarCombo(
            "Curso:",
            "Análise e Desenvolvimento de Sistemas",
            "Administração",
            "Logística"
        );

        btnCancelar = adicionarBotao("Cancelar");
        btnBuscar = adicionarBotao("Buscar aluno");
        btnAtualizar = adicionarBotao("Salvar alterações");

        // Campos inicialmente bloqueados
        txtNome.setEnabled(false);
        txtEmail.setEnabled(false);
        txtAnoIngresso.setEnabled(false);
        cbCurso.setEnabled(false);
        btnAtualizar.setEnabled(false);
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

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnAtualizar() {
        return btnAtualizar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
