package br.com.fortlev.cue.connection;

import br.com.fortlev.cue.util.JdbcConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matheus.s
 */
public class ConexaoBancoMysql {

    private static ConexaoBancoMysql instance = null;
    private int clients = 0;
    private Connection connection = null;
    public Statement stmt;
    public ResultSet rs;
    public Connection con;

    /*
    *  faz comunicação com o banco de dados colocando os dados abaixo.
     */
    // Construtor privado, restrito a classe 
    public ConexaoBancoMysql(){
       /*
        Properties prop = new Properties();
        try {
            //Propriedades

            prop.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String dbDriver = prop.getProperty("db.driver");
            String dbUrl = prop.getProperty("db.url");
            String dbUser = prop.getProperty("db.user");
            String dbPwd = prop.getProperty("db.pwd");

            connection = null;
            Class.forName(dbDriver);
            if (dbUser.length() != 0) {
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);

            } else {
                connection = DriverManager.getConnection(dbUrl);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão do banco de dados, verifique seu o banco está ligado corretamente.", ex);
        }
*/
    }

    // Retorna instancia unica
    public static ConexaoBancoMysql getInstance(){
        if (instance == null) {
            instance = new ConexaoBancoMysql();
        }
        return instance;
    }

    /* 
    * realiza a comunicação com o banco, se caso não estiver online ele trata a exceção. 
     */
    public Connection getConnection(){

        try {
            JdbcConnection jdbc = new JdbcConnection();
            jdbc.getProps();
            if (jdbc.getUrl() == null) {
                jdbc.setProps();
                jdbc.getProps();
            }

            connection = (Connection) DriverManager.getConnection(jdbc.getUrl() + "/" + jdbc.getDatabase(), jdbc.getUser(), jdbc.getPwd());
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoMysql.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        /*
        try {
            if (connection == null || instance.connection.isClosed()) {
                instance = new ConexaoBancoMysql();
            }
        } catch (SQLException ex) {
                instance = new ConexaoBancoMysql();
        }
        
         */
        return connection;
    }

    /*
    * da um close na conexão, desconecta.
     */
    public void closeConnection(Connection con) {

        try {
            if (true) {
                return;
            }
            if (con != null) {
                con.close();
                instance = null;
                System.out.println("DB[conexao fechada]");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Conexão ativa!", ex);

        }

    }

    /*
    * da um close na conexão, desconecta com o preparedstatement.
     */
    public void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Conexão ativa!", ex);
        }

    }

    /*
    * da um close na conexão, desconecta com o preparedstatement com resultset
     */
    public void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Conexão ativa!", ex);
        }

    }

    /*
    * verifica permissão (outra forma de conexão)
     */
    public void conexao() {
        try {
            // System.setProperty("jdbc.Drivers", DRIVER);
            // con=DriverManager.getConnection(URL, USER, PASS);
            if (instance == null) {
                instance = new ConexaoBancoMysql();
            }
            clients++;
            con = instance.connection;

        } catch (Exception ex) {

            System.out.println("Erro na conexão " + ex);
        }
    }

    /*
    * Ele executa sql direto no codigo, outra forma de fazer a conexão direta no banco. 
     */
    public void executaSql(String sql){
        try {
            if (instance == null) {
                instance = new ConexaoBancoMysql();
            }
            clients++;
            con = instance.connection;
            stmt = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {

            System.out.println("executasql " + ex);
        }
    }

}
