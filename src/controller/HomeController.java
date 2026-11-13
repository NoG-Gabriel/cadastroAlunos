package controller;

import view.HomeView;

public class HomeController {

    private HomeView view;

    public HomeController(HomeView view) {

        this.view = view;

        inicializarEventos();
    }

    private void inicializarEventos() {

        view.getBtnCadastrar().addActionListener(e -> {
            // Abrir tela de cadastro
        });

        view.getBtnAtualizar().addActionListener(e -> {
            // Abrir tela de atualização
        });

        view.getBtnConsultar().addActionListener(e -> {
            // Abrir tela de consulta
        });

        view.getBtnListar().addActionListener(e -> {
            // Abrir tela de listagem
        });

        view.getBtnRemover().addActionListener(e -> {
            // Abrir tela de remoção
        });

        view.getBtnTransferir().addActionListener(e -> {
            // Abrir tela de transferência
        });

        view.getBtnTrancar().addActionListener(e -> {
            // Abrir tela de trancamento
        });

        view.getBtnAtivar().addActionListener(e -> {
            // Abrir tela de ativação
        });
    }
}
