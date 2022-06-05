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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    
    // Listar todos os funcionários
    public List<Funcionario> listarFuncionarios(){
        
        try {
            // criando o vetor que vai armazenar os registros do banco
            List<Funcionario> lista = new ArrayList<Funcionario>();
            
            // criando o comando sql
            String cmdSql = "select * from public.Funcionario";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdSql);
            
            // guardando o resultado do select dentro de um objeto result set
            ResultSet rs = stmt.executeQuery();
            
            // enquanto houver registros, guarde o registro na fila
            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("idFuncionario"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setTelefone("telefone");
                f.setSexo(rs.getString("sexo"));
                f.setSalario(rs.getDouble("salario"));
                f.setPis(rs.getString("pis"));
                f.setCargo(rs.getString("cargo"));
                f.setImpostoSobreSalario(rs.getDouble("impostoSobreSalario"));
                
                lista.add(f);
            }
            
            return lista;
        } catch (Exception erroSql) {
            throw new RuntimeException(erroSql);
        }
    }
}
