package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.entity.Tipo;

public class DAOTipo extends DAO 
{

	public DAOTipo(Connection conn) 
	{
		super(conn);
	}
	
	public List<Tipo> getAll(String tabela) throws SQLException
    {
        List<Tipo> tipos = new ArrayList<Tipo>();
        
        ResultSet result = this.getTipos(tabela);

        while (result.next())
        {
            Tipo tipo = new Tipo(
                result.getInt("cd_tipo"),
                result.getString("nm_tipo")
            );

            tipos.add(tipo);
        }

        return tipos;
    }

	private ResultSet getTipos(String tabela) throws SQLException
    {
		Statement stmt = this.conn.createStatement();
		
        String query = "SELECT cd_tipo, nm_tipo FROM " + tabela + " ORDER BY cd_tipo";

        return stmt.executeQuery(query);
    }
	
	public Tipo getById(String tabela, int id) throws SQLException
    {        
        ResultSet result = this.getTipo(tabela, id);

        if (!result.next())
        	throw new SQLException("O Tipo " + id + " não existe");
        
        Tipo tipo = new Tipo(
            result.getInt("cd_tipo"),
            result.getString("nm_tipo")
        );

        return tipo;
    }

	private ResultSet getTipo(String tabela, int id) throws SQLException
    {		
        String query = "SELECT cd_tipo, nm_tipo FROM " + tabela + " WHERE cd_tipo = ? ORDER BY cd_tipo";

        PreparedStatement pstmt = this.conn.prepareStatement(query);

        pstmt.setInt(1, id);

        return pstmt.executeQuery();
    }
}
