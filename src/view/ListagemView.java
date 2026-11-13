
package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListagemView extends BaseView {

    private JTable tabelaAlunos;
    private DefaultTableModel modeloTabela;

    private JButton btnAtualizar;
    private JButton btnFechar;

    public ListagemView() {

        super("Listagem de Alunos", "Alunos cadastrados no instituto");

        String[] colunas = {
            "Matrícula",
            "Nome",
            "Curso",
            "Situação"
        };

        modeloTabela = new DefaultTableModel(colunas, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaAlunos = new JTable(modeloTabela);

        tabelaAlunos.setRowHeight(28);
        tabelaAlunos.setFont(new Font("Arial", Font.PLAIN, 13));
        tabelaAlunos.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 13)
        );

        JScrollPane scroll = new JScrollPane(tabelaAlunos);

        // Substituindo o painel de campos pela tabela
        painelCentral.remove(painelCampos);
        painelCentral.add(scroll, BorderLayout.CENTER);

        btnFechar = adicionarBotao("Fechar");
        btnAtualizar = adicionarBotao("Atualizar lista");
    }

    public JTable getTabelaAlunos() {
        return tabelaAlunos;
    }

    public DefaultTableModel getModeloTabela() {
        return modeloTabela;
    }

    public JButton getBtnAtualizar() {
        return btnAtualizar;
    }

    public JButton getBtnFechar() {
        return btnFechar;
    }
}
