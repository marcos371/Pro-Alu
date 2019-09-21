/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19_02_lp2_alunoprofessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Pessoa;
import modelo.Professor;

/**
 *
 * @author Frank
 */
public class DAO {

    List<Pessoa> listaDePessoas = new ArrayList<>();

    public void salvar(Pessoa pessoa) {
        listaDePessoas.add(pessoa);
    }

    public void exibirTodos(String opcao) {
        String msg = "";
        if (opcao.equals("2")) {
            for (int i = 0; i < listaDePessoas.size(); i++) {
                if (listaDePessoas.get(i) instanceof Aluno) {
                    Aluno aluno = (Aluno) listaDePessoas.get(i);
                    msg += aluno.getNome() + " - RA: " + aluno.getRa() + "\n";
                }
            }
        } else {
            for (int i = 0; i < listaDePessoas.size(); i++) {
                if (listaDePessoas.get(i) instanceof Professor) {
                    Professor professor = (Professor) listaDePessoas.get(i);
                    msg = professor.getNome() + " - SIAPE: " + professor.getSiape();
                }
            }
        }
        JOptionPane.showMessageDialog(null, msg);
    }

    public void remover(long cpf, String opcao) {
        boolean removido = false;

        for (Pessoa pessoa : listaDePessoas) {
            if (pessoa.getCpf() == cpf) {
                if ((opcao.equals("3") && pessoa instanceof Aluno)
                        || (opcao.equals("6") && pessoa instanceof Professor)) {
                    listaDePessoas.remove(pessoa);
                    JOptionPane.showMessageDialog(null, pessoa.getClass().getSimpleName()
                            + " Removido com sucesso!");
                    removido = true;
                }
            }
        }

        if (!removido) {
            JOptionPane.showMessageDialog(null, "CPF não encontrado");
        }
    }
    
    public void salvarNoBD(Aluno aluno) throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/lp2alunoprofessor", "nbuser", "nbuser");
            String sql = "insert into aluno (idpessoa, nome, idade,cpf, ra) " +
                    "values(2,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getIdade());
            ps.setLong(3, aluno.getCpf());
            ps.setInt(4, aluno.getRa());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
}
