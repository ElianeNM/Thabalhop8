package Conexao;


import Conexao.TestConexaoSqlite3;
import Conexao.CrudSala;
import Conexao.CrudTurma;
import java.sql.Statement;
import java.sql.SQLException;

public class Main{
    public static void main(String args[])throws Exception{
        TestConexaoSqlite3 conexao = new TestConexaoSqlite3();
        conexao.abrirConexao();
        CrudSala crud = new CrudSala(conexao.getConnection());
        
        TestConexaoSqlite3 conexao1 = new TestConexaoSqlite3();
        conexao1.abrirConexao();
        CrudTurma crud1 = new CrudTurma(conexao1.getConnection());
        
        //Inserindo cadastros no banco
        crud.create(1, 35); //SALA
        crud.create(2, 35);
        crud.create(3,20);
        
        crud1.create(1, "manhã",2); //TURMA
        crud1.create(2, "tarde",1);
        crud1.create(3,"manhã",3);
        crud1.create(4,"tarde",2);
        crud1.create(4,"tarde",1);
        
        //Consultando uma linha no banco 
        //crud.read(1);
        //crud1.read(2);
      
        //Alterando um registro no banco
        //crud.update(3,35);
        
        //Deletando um registro no banco
        //crud1.delete(2);
    
        
        conexao1.fecharConexao();
        conexao.fecharConexao();     
        
        
    }
}