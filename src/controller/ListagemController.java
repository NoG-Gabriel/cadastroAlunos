package controller;

import model.Aluno;
import service.AlunoServices;
import view.ListagemView;

import javax.swing.table.DefaultTableModel;

public class ListagemController {
    private final ListagemView view;
    private final AlunoServices alunoService;

    public ListagemController(ListagemView view, AlunoServices alunoService) {
        this.view = view;
        this.alunoService = alunoService;
        view.getBtnAtualizar().addActionListener(e -> atualizarLista());
        view.getBtnListarCurso().addActionListener(e -> listarCursoSelecionado());
        view.getBtnFechar().addActionListener(e -> view.dispose());
        atualizarLista();
    }

    public void atualizarLista() {
        DefaultTableModel modelo = view.getModeloTabela();
        modelo.setRowCount(0);
        java.util.List<Aluno> alunos = alunoService.listarAlunos();
        preencherTabela(alunos);
        view.getLblTotal().setText("Total de alunos: " + alunos.size());
    }

    private void listarCursoSelecionado() {
        preencherTabela(alunoService.listarAlunosPorCurso(view.getCbCurso().getSelectedIndex() + 1));
    }

    private void preencherTabela(java.util.List<Aluno> alunos) {
        DefaultTableModel modelo = view.getModeloTabela();
        modelo.setRowCount(0);
        for (Aluno aluno : alunos) {
            modelo.addRow(new Object[]{aluno.getMatricula(), aluno.getNome(),
                    aluno.getCurso().getNomeCurso(), aluno.getSituacao()});
        }
    }
}
