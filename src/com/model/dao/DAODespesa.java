package com.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.entity.despesa.Despesa;
import com.model.entity.despesa.DespesaExceptions.DespesaException;

public class DAODespesa extends DAO
{
    public DAODespesa(Connection conn)
    {
        super(conn);
    }

    public List<Despesa> getAll() throws SQLException, DespesaException
    {
        List<Despesa> despesas = new ArrayList<Despesa>();

        ResultSet result = this.getDespesas();

        while (result.next())
        {
    
            Despesa despesa = new Despesa(
                result.getInt("cd_despesa"),
                result.getInt("t_fp_cliente_cd_cliente"),
                result.getInt("t_fp_tipo_despesa_cd_tipo"),
                result.getString("nm_despesa"),
                result.getDouble("vl_despesa"),
                result.getString("ds_despesa"),
                result.getDate("dt_vencimento")
            );

            despesas.add(despesa);
        }

        return despesas;
    }

    private ResultSet getDespesas() throws SQLException
    {
        Statement stmt = this.conn.createStatement();

        String query = """
            SELECT
                cd_despesa,
                t_fp_cliente_cd_cliente,
                t_fp_tipo_despesa_cd_tipo,
                nm_despesa,
                vl_despesa,
                ds_despesa,
                dt_vencimento

                FROM T_FP_DESPESA
                    ORDER BY cd_despesa
        """;

        return stmt.executeQuery(query);
    }
    
    public List<Despesa> getAll(int idCliente) throws SQLException, DespesaException
    {
        List<Despesa> despesas = new ArrayList<Despesa>();

        ResultSet result = this.getDespesas(idCliente);

        while (result.next())
        {

        	Despesa despesa = new Despesa(
                result.getInt("cd_despesa"),
                result.getInt("t_fp_cliente_cd_cliente"),
                result.getInt("t_fp_tipo_despesa_cd_tipo"),
                result.getString("nm_despesa"),
                result.getDouble("vl_despesa"),
                result.getString("ds_despesa"),
                result.getDate("dt_vencimento")
               );
        	
                despesas.add(despesa);
                
        }
        
        return despesas;
    }
    
    private ResultSet getDespesas(int idCliente) throws SQLException
    {        
    	String query = """
            SELECT
                cd_despesa,
                t_fp_cliente_cd_cliente,
                t_fp_tipo_despesa_cd_tipo,
                nm_despesa,
                vl_despesa,
                ds_despesa,
                dt_vencimento
       
                FROM T_FP_DESPESA
    			    WHERE t_fp_cliente_cd_cliente = ?
                    ORDER BY dt_vencimento DESC
        """;

        PreparedStatement pstmt = this.conn.prepareStatement(query);

        pstmt.setInt(1, idCliente);

        return pstmt.executeQuery();
    }

    public Despesa getById(int id) throws SQLException, DespesaException
    {
        ResultSet result = this.getDespesa(id);

        if (!result.next())
            throw new SQLException("A despesa " + id + " não existe");


        Despesa despesa = new Despesa(
            result.getInt("cd_despesa"),
            result.getInt("t_fp_cliente_cd_cliente"),
            result.getInt("t_fp_tipo_despesa_cd_tipo"),
            result.getString("nm_despesa"),
            result.getDouble("vl_despesa"),
            result.getString("ds_despesa"),
            result.getDate("dt_vencimento")
        );

        return despesa;
    }

    private ResultSet getDespesa(int id) throws SQLException
    {
        String query = """
            SELECT
                cd_despesa,
                nm_despesa,
                vl_despesa,
                ds_despesa,
                dt_vencimento,
                t_fp_cliente_cd_cliente,
                t_fp_tipo_despesa_cd_tipo

                FROM T_FP_DESPESA
                    WHERE cd_despesa = ?
        """;

        PreparedStatement pstmt = this.conn.prepareStatement(query);

        pstmt.setInt(1, id);

        return pstmt.executeQuery();
    }

    public void insert(Despesa despesa) throws SQLException
    {
        CallableStatement cs = conn.prepareCall("{ call InserirDespesa(?, ?, ?, ?, ?, ?) }");

        cs.setString(1, despesa.getNome());
        cs.setDouble(2, despesa.getValor());
        cs.setString(3, despesa.getDescricao());
        cs.setDate(4, new java.sql.Date(despesa.getDataVencimento().getTime()));
        cs.setInt(5, despesa.getIdTipoDespesa());
        cs.setInt(6, despesa.getIdCliente());
        cs.execute();
    }

    public void update(Despesa despesa) throws SQLException
    {
        CallableStatement cs = conn.prepareCall("{ call AtualizarDespesa(?, ?, ?, ?, ?, ?) }");

        cs.setInt(1, despesa.getId());
        cs.setString(2, despesa.getNome());
        cs.setDouble(3, despesa.getValor());
        cs.setString(4, despesa.getDescricao());
        cs.setDate(5, new java.sql.Date(despesa.getDataVencimento().getTime()));
        cs.setInt(6, despesa.getIdTipoDespesa());
        cs.execute();
    }

    public void delete(int id) throws SQLException, DespesaException
    {
        Despesa despesa = this.getById(id);

        String deleteQuery = """
            DELETE FROM T_FP_DESPESA
                WHERE cd_despesa = ?
        """;

        PreparedStatement pstmt = this.conn.prepareStatement(deleteQuery);

        pstmt.setInt(1, despesa.getId());

        pstmt.executeUpdate();
    }
}