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
        crud.read(1); //linha onde o Id_sala da tabela Sala é 1
        crud1.read(2); //linha onde o Id_turma da tabela Turma é 2
      
        //Alterando um registro no banco
        crud.update(3,35); //atualizando capacidade da Sala com Id_sala 3 para 35(alunos)
        
        //Deletando um registro no banco
        crud1.delete(2); //deletando o registro da tabela Turma onde Id_turma é 2
        //crud1.delete(1);  
        //crud1.delete(2);
        //crud1.delete(3);
        //crud1.delete(4);
        //crud.delete(1);
        //crud.delete(2);
        //crud.delete(3);
        
        conexao1.fecharConexao();
        conexao.fecharConexao();     
        
        
    }
}