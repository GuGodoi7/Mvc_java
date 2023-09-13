package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.fiap.model.bean.Cliente;

public class ClienteDAO {
	private Connection con;
	private Cliente cliente;

	public ClienteDAO(Connection con) {
		super();
		this.con = con;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		cliente = (Cliente)obj;
		String sql = "insert into carro(placa,cor,descricao)values(?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNomeCliente());
			ps.setString(3, cliente.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}	
	public String alterar(Object obj) {
		cliente = (Cliente)obj;
		String sql = "update carro ";
		sql += "set cor = ?, descricao = ?";
		sql += "where placa = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNomeCliente());
			ps.setString(3, cliente.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Atualizado com sucesso.";
			} else {
				return "Erro ao Alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	public String excluir(Object obj) {
		cliente = (Cliente)obj;
		String sql = "delete from carro where placa = ?";
		
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, cliente.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso.";
			} else {
				return "Excluido ao Alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	public String listarTodos() {
		String sql = "select * from carro";
		String listaCarro = "Lista dos carros\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if ( (rs != null)) {
				while (rs.next()) {
					listaCarro += "Placa: " + rs.getString(1) + "\n";
					listaCarro += "Cor: " + rs.getString(2) + "\n";
					listaCarro += "descricao: " + rs.getString(3) + "\n\n";
				}
				return listaCarro;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			return null;
		}
	}
	
	
	

}
