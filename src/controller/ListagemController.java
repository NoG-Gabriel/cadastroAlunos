package controller;

import model.Aluno;
import service.AlunoServices;
import view.ListagemView;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import enums.Situacao;

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
        List<Aluno> alunos = alunoService.listarAlunos();
        preencherTabela(alunos);
        view.getLblTotal().setText("Total de alunos: " + alunos.size());
    }

    private void listarCursoSelecionado() {
        preencherTabela(alunoService.listarAlunosPorCurso(view.getCbCurso().getSelectedIndex() + 1));
    }

    private void preencherTabela(List<Aluno> alunos) {
        DefaultTableModel modelo = view.getModeloTabela();
        modelo.setRowCount(0);
        for (Aluno aluno : alunos) {
        	
        	/*if (aluno.getSituacao() == Situacao.ATIVO) {
        		modelo.addRow(new Object[]{aluno.getMatricula(), aluno.getNome(), 
            		aluno.getCurso().getNomeCurso(), aluno.getSituacao()});
        	}
        	*/
        	modelo.addRow(new Object[]{aluno.getMatricula(), aluno.getNome(), 
            		aluno.getCurso().getNomeCurso(), aluno.getSituacao()});
            
        }
    }
}
