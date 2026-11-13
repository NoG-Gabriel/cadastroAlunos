package view;

import javax.swing.*;
import java.awt.*;

public abstract class BaseView extends JFrame {

    protected JPanel painelCentral;
    protected JPanel painelCampos;
    protected JPanel painelAcoes;

    public BaseView(String titulo, String subtitulo) {

        setTitle("Instituto Horizonte - " + titulo);
        setSize(700, 550);
        setMinimumSize(new Dimension(600, 450));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Cabeçalho
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(new Color(20, 45, 78));
        header.setBorder(
            BorderFactory.createEmptyBorder(25, 30, 25, 30)
        );

        JLabel tituloLabel = new JLabel("INSTITUTO HORIZONTE");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 23));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtituloLabel = new JLabel(subtitulo);
        subtituloLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtituloLabel.setForeground(new Color(210, 225, 240));
        subtituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(tituloLabel);
        header.add(Box.createVerticalStrut(8));
        header.add(subtituloLabel);

        // Área central
        painelCentral = new JPanel(new BorderLayout(15, 15));
        painelCentral.setBackground(new Color(245, 247, 250));
        painelCentral.setBorder(
            BorderFactory.createEmptyBorder(30, 40, 25, 40)
        );

        painelCampos = new JPanel(new GridLayout(0, 2, 12, 15));
        painelCampos.setOpaque(false);

        painelAcoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelAcoes.setOpaque(false);

        painelCentral.add(painelCampos, BorderLayout.CENTER);
        painelCentral.add(painelAcoes, BorderLayout.SOUTH);

        add(header, BorderLayout.NORTH);
        add(painelCentral, BorderLayout.CENTER);
    }

    // Adicionar campo de texto
    protected JTextField adicionarCampo(String nome) {

        JLabel label = new JLabel(nome);
        label.setFont(new Font("Arial", Font.BOLD, 13));

        JTextField campo = new JTextField();
        campo.setFont(new Font("Arial", Font.PLAIN, 14));

        painelCampos.add(label);
        painelCampos.add(campo);

        return campo;
    }

    // Adicionar lista de opções
    protected JComboBox<String> adicionarCombo(
            String nome, String... opcoes) {

        JLabel label = new JLabel(nome);
        label.setFont(new Font("Arial", Font.BOLD, 13));

        JComboBox<String> combo = new JComboBox<>(opcoes);

        painelCampos.add(label);
        painelCampos.add(combo);

        return combo;
    }

    // Adicionar botão
    protected JButton adicionarBotao(String texto) {

        JButton botao = new JButton(texto);

        botao.setFont(new Font("Arial", Font.BOLD, 13));
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(35, 85, 130));
        botao.setFocusPainted(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

        painelAcoes.add(botao);

        return botao;
    }
}
