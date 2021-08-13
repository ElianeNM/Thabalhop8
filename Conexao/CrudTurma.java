package Conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudTurma
{
    //cria o objeto do tipo conexão
    private Connection conexao1;
    public CrudTurma(Connection conexao1){
        this.conexao1 = conexao1;
    }
    
    public boolean create(int Id_turma, String turno_turma,int sala){
        try{
            
            Statement statement = this.conexao1.createStatement(); 
            statement.executeUpdate("INSERT INTO Turma VALUES("+Id_turma+", '"+turno_turma+"',"+sala+")");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean read(int Id_turma){
        try{
            Statement statement = this.conexao1.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Turma WHERE Id_turma = "+Id_turma);

            
            
            while (rs.next()) {
                Integer id = rs.getInt("Id_turma");
                String turno_turma = rs.getString("turno_turma");
                Integer sala = rs.getInt("sala");  
                
                System.out.println( Id_turma +" - " + turno_turma + " - " + sala );
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean update(int Id_turma, String novoTurno){
        try{
            Statement statement = this.conexao1.createStatement();
            statement.executeUpdate("UPDATE Turma SET turno_turma ='"+novoTurno+"' WHERE Id_turma ="+Id_turma);
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean delete(int Id_turma){
        try{
            Statement statement = this.conexao1.createStatement();
            statement.executeUpdate("DELETE FROM Turma WHERE Id_turma ="+Id_turma+"");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}

