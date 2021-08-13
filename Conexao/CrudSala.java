package Conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudSala
{
    //cria o objeto do tipo conexão
    private Connection conexao;
    public CrudSala(Connection conexao){
        this.conexao = conexao;
    }
    
    public boolean create(int  Id_sala, int capacidade_sala){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Sala VALUES("+Id_sala+" , "+capacidade_sala+")");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean read(int Id_sala){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Sala WHERE Id_sala = "+Id_sala);

        
            
            while (rs.next()) {
                Integer id = rs.getInt("Id_sala");
                Integer capacidade_sala = rs.getInt("capacidade_sala");

                System.out.println( Id_sala +" - " +capacidade_sala);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean update(int Id_sala, int novaCapacidade){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE Sala SET capacidade_sala ="+novaCapacidade+" WHERE Id_sala ="+Id_sala);
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean delete(int Id_sala){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE FROM Sala WHERE Id_sala ="+Id_sala+"");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
