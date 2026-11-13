package view;

import javax.swing.*;
import java.awt.*;

public class ConsultaView extends BaseView {

    private JTextField txtMatricula;
    private JTextArea txtResultado;

    private JButton btnConsultar;
    private JButton btnCancelar;

    public ConsultaView() {

        super("Consulta de Aluno", "Consultar informações acadêmicas");

        txtMatricula = adicionarCampo("Matrícula:");

        txtResultado = new JTextArea(8, 30);
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Arial", Font.PLAIN, 14));

        adicionarLinha(new JLabel("Resultado:"), new JScrollPane(txtResultado));

        btnCancelar = adicionarBotao("Cancelar");
        btnConsultar = adicionarBotao("Consultar");
    }

    public JTextField getTxtMatricula() {
        return txtMatricula;
    }

    public JTextArea getTxtResultado() {
        return txtResultado;
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
