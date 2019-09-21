package dadospessoais;

import javax.swing.JOptionPane;
import java.sql.*;

public class DadosPessoais {

    
      static BancoDados dao = new BancoDados();   
    static Leitura ler = new Leitura();
    public static void main(String args[]) throws SQLException, Exception {
        
        boolean op = true;
        while (op) {
            String opcao = JOptionPane.showInputDialog(null, "[1] - Salvar\n[2] -"
                    + " Exibir\n[3] - "
                    + "Exibir Todos\n[4] - "
                    + "Remover\n[5] - "
                    + "Alterar\n[0] - "
                    + "Sair",
                    "Menu Principal",
                     JOptionPane.INFORMATION_MESSAGE);

            switch (opcao) {
                case "1": {
                    int o = op();
                    if (o >= 0 && o < 3) {
                        dao.salvarBd(o);
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção invalida!");
                    }
                }
                break;
                case "2": {
                    int o = op();
                    if (o >= 0 && o < 3) {
                        dao.buscarBd(o);
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção invalida!");
                    }
                }
                break;
                case "3": {
                    int o = op();
                    if (o >= 0 && o < 3) {
                        dao.buscarTBd(o);
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção invalida!");
                    }
                }
                break;
                case "4": {
                    int o = op();
                    if (o > 0 && o < 3) {
                        dao.remover(o);
                    }
                }
                break;
                case "5": {
                    int o = op();
                    if (o > 0 && o < 3) {
                        dao.alterar(o);
                    }
                }
                break;
                case "0": {
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    op = false;
                }
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção invalida!");
            }
        }
    }

    public static int op() {
        String opcao = JOptionPane.showInputDialog(null, "[1] - Professor\n[2]"
                + " - Aluno\n[0] - Sair",
                "Menu", JOptionPane.INFORMATION_MESSAGE);
        return Integer.parseInt(opcao);
    }
}
