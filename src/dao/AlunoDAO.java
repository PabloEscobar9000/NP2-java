package dao;

import com.mysql.cj.protocol.Resultset;
import factory.ConnectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Aluno;

public class AlunoDAO {
    private Connection connection;
    PreparedStatement stmt;
    ArrayList<Aluno> lista = new ArrayList<>();
    ResultSet rs;
    
    public AlunoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void inserir(Aluno aluno) throws SQLException{ 
        String sql = "INSERT INTO aluno(aluno_nome) VALUES(?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(1, aluno.getCpf());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    Connection conn;
    PreparedStatement pstm;
    
    public void inserirAluno(Aluno objaluno1){
        String sql = "insert into aluno (cpf_aluno, aluno_nome, dat_nasc, peso, altura) values(?,?,?,?,?)";
        
        
        conn = new ConnectionFactory().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objaluno1.getCpf());
            pstm.setString(2, objaluno1.getNome());
            pstm.setString(3, objaluno1.getDatNasc());
            pstm.setFloat(4, objaluno1.getPeso());
            pstm.setFloat(5, objaluno1.getAltura());
            
            pstm.execute();
            pstm.close();
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "alunoDAO "+ erro);
        }
    }
    
    public ArrayList<Aluno> ConsultarAluno(){
        String sql = "select * from aluno";
        connection = new ConnectionFactory().getConnection();
        
        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Aluno objaluno1 = new Aluno();
                objaluno1.setNome(rs.getString("aluno_nome"));
                objaluno1.setCpf(rs.getString("cpf_aluno"));
                objaluno1.setDatNasc(rs.getString("dat_nasc"));
                objaluno1.setPeso(rs.getFloat("peso"));
                objaluno1.setAltura(rs.getFloat("altura"));
                
                lista.add(objaluno1);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Aluno consultar: " + erro);
        }
        return lista;
    }
    
    public void alterarAluno(Aluno objaluno1){
        String sql = "update aluno set aluno_nome = ?, peso = ?, dat_nasc = ?, altura = ?    where cpf_aluno = ?";
        
        conn = new ConnectionFactory().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objaluno1.getNome());
            pstm.setFloat(2, objaluno1.getPeso());
            pstm.setString(3, objaluno1.getDatNasc());
            pstm.setFloat(4, objaluno1.getAltura());
            pstm.setString(5, objaluno1.getCpf());
            
            
           
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "alunoAlterar "+ erro);
        }
    }
    
    public void excluirAluno(Aluno objaluno1){
        String sql = "delete from aluno where cpf_aluno =?";
        
        conn = new ConnectionFactory().getConnection();
        
        try {
           
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objaluno1.getCpf());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "alunoExcluir "+ erro);
        }
    }
    
   public ArrayList<Aluno> lerAluno(String desc){
        String sql = "select * from aluno where cpf_aluno = ?";
        
        conn = new ConnectionFactory().getConnection();
        
        try {
           
            pstm = conn.prepareStatement(sql);
            //pstm.setString(1, desc.getCpf()); AQUI TEM UM ERRO
            
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Aluno objaluno1 = new Aluno();
                objaluno1.setNome(rs.getString("aluno_nome"));
                objaluno1.setCpf(rs.getString("cpf_aluno"));
                objaluno1.setDatNasc(rs.getString("dat_nasc"));
                objaluno1.setPeso(rs.getFloat("peso"));
                
                lista.add(objaluno1);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Aluno consultar: " + erro);
        }
        return lista;
    }
    
        
        
        
        
}
        

    
  
