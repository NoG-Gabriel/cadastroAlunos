package controller;

import view.*;
import service.AlunoServices;
import service.CursoService;
import controller.CadastroController;
import controller.AtualizacaoController;
import controller.ConsultaController;
import controller.ListagemController;
import controller.RemocaoController;
import controller.TransferenciaController;
import controller.SituacaoController;

import javax.swing.JFrame;

public class HomeController {

    private HomeView view;
    private final AlunoServices alunoService;
    private final CursoService cursoService;

    public HomeController(HomeView view, AlunoServices alunoService, CursoService cursoService) {

        this.view = view;
        this.alunoService = alunoService;
        this.cursoService = cursoService;

        inicializarEventos();
    }

    private void inicializarEventos() {

        view.getBtnCadastrar().addActionListener(e -> {
            CadastroView tela = new CadastroView();
            new CadastroController(tela, alunoService, cursoService);
            abrirTela(tela);
        });

        view.getBtnAtualizar().addActionListener(e -> {
            AtualizacaoView tela = new AtualizacaoView();
            new AtualizacaoController(tela, alunoService, cursoService);
            abrirTela(tela);
        });

        view.getBtnConsultar().addActionListener(e -> {
            ConsultaView tela = new ConsultaView();
            new ConsultaController(tela, alunoService);
            abrirTela(tela);
        });

        view.getBtnListar().addActionListener(e -> {
            ListagemView tela = new ListagemView();
            new ListagemController(tela, alunoService);
            abrirTela(tela);
        });

        view.getBtnRemover().addActionListener(e -> {
            RemocaoView tela = new RemocaoView();
            new RemocaoController(tela, alunoService);
            abrirTela(tela);
        });

        view.getBtnTransferir().addActionListener(e -> {
            TransferenciaView tela = new TransferenciaView();
            new TransferenciaController(tela, alunoService);
            abrirTela(tela);
        });

        view.getBtnTrancar().addActionListener(e -> {
            abrirSituacao();
        });

        view.getBtnAtivar().addActionListener(e -> {
            abrirSituacao();
        });
    }

    private void abrirTela(JFrame tela) {
        tela.setLocationRelativeTo(view);
        tela.setVisible(true);
    }

    private void abrirSituacao() {
        SituacaoView tela = new SituacaoView();
        new SituacaoController(tela, alunoService);
        abrirTela(tela);
    }
}
