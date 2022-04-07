package br.com.fortlev.cue.dao;

import br.com.fortlev.cue.bean.Empilhadeira;
import br.com.fortlev.cue.bean.Manutencao;
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
public class ManutencaoDAO {
    public boolean create(Manutencao mnt) throws Exception {
        Connection con = ConexaoBancoMysql.getInstance().getConnection();
        PreparedStatement stmt = null;

        /*
        * aplicando as informações no banco de dados com tratamento de exceção.
         */
        try {
            String sql = "INSERT INTO tb_manutencao (tiposervico, data, horimetro, horimetromanutencao, empilhadeira, pecasutilizadas, responsavel)VALUES(?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, mnt.getTipoDeServico());
            stmt.setDate(2, new java.sql.Date(mnt.getData().getTime()));
            stmt.setInt(3, mnt.getHorimetro());
            stmt.setInt(4, mnt.getHorimetroManutencao());
            stmt.setString(5, mnt.getEmpilha());
            stmt.setString(6, mnt.getPecasUtilizadas());
            stmt.setString(7, mnt.getResponsavel());

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
    public List<Manutencao> readVarious() throws Exception {

        List<Manutencao> mnt = new LinkedList<Manutencao>();
        // abrindo conexão e preparando.
        Connection con = ConexaoBancoMysql.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_manutencao");
            rs = stmt.executeQuery();

            while (rs.next()) {

                mnt.add(new Manutencao(rs.getInt("id"),
                        rs.getString("tiposervico"),
                        rs.getDate("data"),
                        rs.getInt("horimetro"),
                rs.getInt("horimetromanutencao"),
                rs.getString("empilhadeira"),
                rs.getString("pecasutilizadas"),
                rs.getString("responsavel")));
            }

        } catch (SQLException ex) {
            
            System.out.println(ex);

        } finally {
            ConexaoBancoMysql.getInstance().closeConnection(con, stmt, rs);
        }

        return mnt;
    }

    /*
    * realizar update no banco de dados.
     */
    public boolean update(Manutencao mnt) {
        Connection con = ConexaoBancoMysql.getInstance().getConnection();
        PreparedStatement stmt = null;

        // aplicando as informações no banco de dados com tratamento de exceção. 
        try {
            stmt = con.prepareStatement("UPDATE tb_manutencao SET tiposervico = ?, data = ?, horimetro = ?, horimetromanutencao = ?, empilhadeira = ?, pecasutilizadas = ?, responsavel = ? WHERE id = ? ");

            stmt.setString(1, mnt.getTipoDeServico());
            stmt.setDate(2, new java.sql.Date(mnt.getData().getTime()));
            stmt.setInt(3, mnt.getHorimetro());
            stmt.setInt(4, mnt.getHorimetroManutencao());
            stmt.setString(5, mnt.getEmpilha());
            stmt.setString(6, mnt.getPecasUtilizadas());
            stmt.setString(7, mnt.getResponsavel());
            stmt.setInt(8, mnt.getId());

            stmt.executeUpdate();
            
            return true;

        } catch (SQLException ex) {
            System.out.println(ex + "linha 113 DAO Manutencao");
            return false;
        } finally {
            ConexaoBancoMysql.getInstance().closeConnection(con, stmt);
        }

    }

    /*
    * deletando a mntresa
     */
    public boolean delete(Empilhadeira mnt) throws Exception {

        Connection con = ConexaoBancoMysql.getInstance().getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tb_manutencao WHERE id = ?");
            stmt.setInt(1, mnt.getId());

            stmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            System.out.println(ex + "Linha 138 DAO Manutencao");
            return false;
        } finally {
            ConexaoBancoMysql.getInstance().closeConnection(con, stmt);
        }

    }
    
    
}
