/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetopoo;

import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import telas.frmTelaInicial;

/**
 *
 * @author multiway
 */
public class ProjetoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//         try {
//            JOptionPane.showMessageDialog(null, "Testando a conexão");
//            Connection con = new ConnectionFactory().conecta();
//            JOptionPane.showMessageDialog(null, "Está conectado");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro ao conectar " + e);
//        }
         
        JFrame frame = new frmTelaInicial("Tela Inicial");
        frame.setVisible(true);
        
    }
    
}
