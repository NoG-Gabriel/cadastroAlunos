
package view;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JFrame {

    // Botões de navegação
    private JButton btnCadastrar;
    private JButton btnAtualizar;
    private JButton btnConsultar;
    private JButton btnListar;
    private JButton btnRemover;
    private JButton btnTransferir;
    private JButton btnTrancar;
    private JButton btnAtivar;

    public HomeView() {

        setTitle("Instituto Horizonte - Sistema Acadêmico");
        setSize(900, 650);
        setMinimumSize(new Dimension(750, 550));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(125, 135, 158));

        // Cabeçalho
        JPanel painelHeader = new JPanel();
        painelHeader.setLayout(new BoxLayout(painelHeader, BoxLayout.Y_AXIS));
        painelHeader.setBackground(new Color(20, 45, 78));
        painelHeader.setBorder(
            BorderFactory.createEmptyBorder(30, 40, 30, 40)
        );

        JLabel titulo = new JLabel("INSTITUTO HORIZONTE");
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Sistema de Gerenciamento Acadêmico");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitulo.setForeground(new Color(210, 225, 240));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelHeader.add(titulo);
        painelHeader.add(Box.createVerticalStrut(10));
        painelHeader.add(subtitulo);

        // Área central
        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.setBackground(new Color(255, 255, 255));
        painelCentral.setBorder(
            BorderFactory.createEmptyBorder(35, 50, 30, 50)
        );

        JLabel boasVindas = new JLabel("Seja bem vindo ao sistema!");
        boasVindas.setFont(new Font("Arial", Font.BOLD, 24));
        boasVindas.setForeground(new Color(30, 50, 75));

        JLabel descricao = new JLabel("Selecione uma opção para continuar.");
        descricao.setFont(new Font("Arial", Font.PLAIN, 14));
        descricao.setForeground(Color.GRAY);

        JPanel painelTextos = new JPanel();
        painelTextos.setLayout(new BoxLayout(painelTextos, BoxLayout.Y_AXIS));
        painelTextos.setOpaque(false);

        painelTextos.add(boasVindas);
        painelTextos.add(Box.createVerticalStrut(8));
        painelTextos.add(descricao);

        // Painel dos botões
        JPanel painelBotoes = new JPanel(new GridLayout(4, 2, 20, 15));
        painelBotoes.setOpaque(false);
        painelBotoes.setBorder(
            BorderFactory.createEmptyBorder(30, 0, 20, 0)
        );

        // Criando botões
        btnCadastrar = criarBotao("Cadastrar aluno");
        btnAtualizar = criarBotao("Atualizar aluno");
        btnConsultar = criarBotao("Consultar aluno");
        btnListar = criarBotao("Listar alunos");
        btnRemover = criarBotao("Remover aluno");
        btnTransferir = criarBotao("Transferir curso");
        btnTrancar = criarBotao("Trancar aluno");
        btnAtivar = criarBotao("Ativar aluno");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnConsultar);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnTransferir);
        painelBotoes.add(btnTrancar);
        painelBotoes.add(btnAtivar);

        painelCentral.add(painelTextos, BorderLayout.NORTH);
        painelCentral.add(painelBotoes, BorderLayout.CENTER);

        // Montagem da interface
        painelPrincipal.add(painelHeader, BorderLayout.NORTH);
        painelPrincipal.add(painelCentral, BorderLayout.CENTER);


        add(painelPrincipal);
    }

    // Método auxiliar para criação dos botões
    private JButton criarBotao(String texto) {

        JButton botao = new JButton(texto);

        botao.setFont(new Font("Arial", Font.BOLD, 15));
        botao.setForeground(new Color(255, 255, 255));
        botao.setBackground(Color.DARK_GRAY);

        botao.setFocusPainted(false);
        botao.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    new Color(210, 220, 230)
                ),
                BorderFactory.createEmptyBorder(15, 10, 15, 10)
            )
        );

        botao.setCursor(
            new Cursor(Cursor.HAND_CURSOR)
        );

        return botao;
    }

    // Getters para o Controller

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    public JButton getBtnAtualizar() {
        return btnAtualizar;
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public JButton getBtnListar() {
        return btnListar;
    }

    public JButton getBtnRemover() {
        return btnRemover;
    }

    public JButton getBtnTransferir() {
        return btnTransferir;
    }

    public JButton getBtnTrancar() {
        return btnTrancar;
    }

    public JButton getBtnAtivar() {
        return btnAtivar;
    }


    
}
