package br.com.fortlev.cue.dao;

import br.com.fortlev.cue.bean.Empilhadeira;
import br.com.fortlev.cue.connection.ConexaoBancoMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author matheus.s
 */
public class EmpilhadeiraDAO {

    public boolean create(Empilhadeira emp) throws Exception {
        Connection con = ConexaoBancoMysql.getInstance().getConnection();
        PreparedStatement stmt = null;

        /*
        * aplicando as informações no banco de dados com tratamento de exceção.
         */
        try {
            String sql = "INSERT INTO tb_empilhadeira (numeroemp, numerodeserie, modelo)VALUES(?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, emp.getNumeroEmp());
            stmt.setInt(2, emp.getNumeroDeSerie());
            stmt.setString(3, emp.getModelo());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {

            System.out.println(ex);
            return false;
        } finally {
            ConexaoBancoMysql.getInstance().closeConnection(con, stmt);
        }

    }

    /*
    * list para puxar os produtos do banco de dados.
     */
    public List<Empilhadeira> readVarious() throws Exception {

        List<Empilhadeira> emp = new LinkedList<Empilhadeira>();
        // abrindo conexão e preparando.
        Connection con = ConexaoBancoMysql.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_empilhadeira");
            rs = stmt.executeQuery();

            while (rs.next()) {

                emp.add(new Empilhadeira(rs.getInt("id"),
                        rs.getInt("numeroemp"),
                        rs.getInt("numerodeserie"),
                        rs.getString("modelo")));
            }

        } catch (SQLException ex) {

            System.out.println(ex);

        } finally {
            ConexaoBancoMysql.getInstance().closeConnection(con, stmt, rs);
        }

        return emp;
    }


    /*
    * realizar update no banco de dados.
     */
    public boolean update(Empilhadeira emp) {
        Connection con = ConexaoBancoMysql.getInstance().getConnection();
        PreparedStatement stmt = null;

        // aplicando as informações no banco de dados com tratamento de exceção. 
        try {
            stmt = con.prepareStatement("UPDATE tb_empilhadeira SET numeroemp = ?, numerodeserie = ?, modelo = ? WHERE id = ? ");

            stmt.setInt(1, emp.getNumeroEmp());
            stmt.setInt(2, emp.getNumeroDeSerie());
            stmt.setString(3, emp.getModelo());
            stmt.setInt(8, emp.getId());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex + "linha 105 DAO Empilhadeira");
            return false;
        } finally {
            ConexaoBancoMysql.getInstance().closeConnection(con, stmt);
        }

    }

    /*
    * deletando a empresa
     */
    public boolean delete(Empilhadeira emp) throws Exception {

        Connection con = ConexaoBancoMysql.getInstance().getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tb_empilhadeira WHERE id = ?");
            stmt.setInt(1, emp.getId());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex + "Linha 130 DAO Empilhadeira");
            return false;
        } finally {
            ConexaoBancoMysql.getInstance().closeConnection(con, stmt);
        }

    }

}
