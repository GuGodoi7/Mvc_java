package br.com.fiap.controller;

import java.sql.Connection;
import br.com.fiap.model.bean.Cliente;
import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.dao.Conexao;

public class ClienteController {
	public String insereCliente(String placa, int idCliente, String nomeCliente) {
		String resltado;
		Connection con = Conexao.abrirConexao();

		Cliente clienteBean = new Cliente();
		clienteBean.setNomeCliente(nomeCliente);
		clienteBean.setNomeCliente(nomeCliente);
		clienteBean.setPlaca(placa);
		
		ClienteDAO clienteDao = new ClienteDAO(con);
		resltado = clienteDao.inserir(clienteBean);

		Conexao.fecharConexao(con);
		return resltado;
	}
	
	public String alteraCliente(String placa, int idCliente, String nomeCliente) {
		String resltado;
		Connection con = Conexao.abrirConexao();

		Cliente clienteBean = new Cliente();
		clienteBean.setNomeCliente(nomeCliente);
		clienteBean.setNomeCliente(nomeCliente);
		clienteBean.setPlaca(placa);
		
		ClienteDAO clienteDao = new ClienteDAO(con);
		resltado = clienteDao.alterar(clienteBean);

		Conexao.fecharConexao(con);
		return resltado;
	}
	public String alteraCliente(String placa) {
		String resltado;
		Connection con = Conexao.abrirConexao();

		Cliente clienteBean = new Cliente();
		clienteBean.setPlaca(placa);
		
		ClienteDAO clienteDao = new ClienteDAO(con);
		resltado = clienteDao.excluir(clienteBean);

		Conexao.fecharConexao(con);
		return resltado;
	}
	
	public String listaCarro() {
		String reseltado = "";
		Connection con = Conexao.abrirConexao();
		ClienteDAO clienteDao = new ClienteDAO(con);
		reseltado = clienteDao.listarTodos();

		Conexao.fecharConexao(con);
		if (reseltado != null) {
			return reseltado;
		} else {
			return null;

		}
	}

}
