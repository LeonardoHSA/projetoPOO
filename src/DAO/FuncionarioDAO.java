/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
        
import java.sql.Connection;
import jdbc.ConnectionFactory;
import javaBeans.Funcionario;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Leonardo
 */
public class FuncionarioDAO {
    
    private Connection conecta;
    
    public FuncionarioDAO(){
        this.conecta = new ConnectionFactory().conecta();
    }
    
    //Método cadastrar cliente
    public void cadastrarFuncioanrio(Funcionario obj){
        
        try {
            
            // criando o comando sql
            String cmdsql = "insert into public.Funcionario (nome, cpf, rg, telefone, sexo, salario, pis, cargo, impostoSobreSalario) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // organizando o cmdsql e executando
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getRg());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getSexo());
            stmt.setDouble(6, obj.getSalario());
            stmt.setString(7, obj.getPis());
            stmt.setString(8, obj.getCargo());
            stmt.setDouble(9, obj.getImpostoSobreSalario());
            
            stmt.execute();
            
            // fechando a conexão
            stmt.close();
            
        } catch (SQLException erroSQL) {
            throw new RuntimeException(erroSQL);
        }
    }
}
