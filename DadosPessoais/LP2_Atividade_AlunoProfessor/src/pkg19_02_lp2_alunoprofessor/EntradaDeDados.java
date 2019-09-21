/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19_02_lp2_alunoprofessor;

import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Professor;

/**
 *
 * @author Frank
 */
public class EntradaDeDados {

    DAO dao = new DAO();

    public void entradaPessoa(String opcao) {
        String nome = "frank";//JOptionPane.showInputDialog("Nome: ");
        String sexo = "masc";//JOptionPane.showInputDialog("Sexo: ");
        long cpf = 33;//Long.parseLong(JOptionPane.showInputDialog("CPF: "));
        int idade = 34;//Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
        if (opcao.equals("1")) {
            Aluno aluno = new Aluno(nome, sexo, cpf, idade);
            aluno.setRa(1111);//Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
            dao.salvarNoBD(aluno);
        } else {
            Professor professor = new Professor(nome, sexo, cpf, idade);
            professor.setSiape(Long.parseLong(JOptionPane.showInputDialog("SIAPE: ")));
            dao.salvar(professor);
        }
    }
    
    public void exibirTodos(String opcao){
        dao.exibirTodos(opcao);
    }
    
    public void remover(String opcao){
        String cpf = JOptionPane.showInputDialog("Entre com o cpf de quem deseja remover: ");
        dao.remover(Long.parseLong(cpf), opcao);
    }
}
