package br.com.fiap.controller;

import java.sql.Connection;

import br.com.fiap.model.bean.Carro;
import br.com.fiap.model.dao.CarroDAO;
import br.com.fiap.model.dao.Conexao;

public class CarroController {
	public String insereCarro(String placa, String cor, String descricao) {
		String resltado;
		Connection con = Conexao.abrirConexao();

		Carro carroBean = new Carro();
		carroBean.setPlaca(placa);
		carroBean.setCor(cor);
		carroBean.setDescricao(descricao);
		CarroDAO carroDao = new CarroDAO(con);
		resltado = carroDao.inserir(carroBean);

		Conexao.fecharConexao(con);
		return resltado;
	}

	public String alterarCarro(String placa, String cor, String descricao) {
		String resltado;
		Connection con = Conexao.abrirConexao();

		Carro carroBean = new Carro();
		carroBean.setPlaca(placa);
		carroBean.setCor(cor);
		carroBean.setDescricao(descricao);
		CarroDAO carroDao = new CarroDAO(con);
		resltado = carroDao.alterar(carroBean);

		Conexao.fecharConexao(con);
		return resltado;
	}

	public String excluirCarro(String placa) {
		String resltado;
		Connection con = Conexao.abrirConexao();

		Carro carroBean = new Carro();
		carroBean.setPlaca(placa);
		CarroDAO carroDao = new CarroDAO(con);
		resltado = carroDao.inserir(carroBean);

		Conexao.fecharConexao(con);
		return resltado;
	}

	public String listaCarro() {
		String reseltado = "";
		Connection con = Conexao.abrirConexao();
		CarroDAO carroDao = new CarroDAO(con);
		reseltado = carroDao.listarTodos();

		Conexao.fecharConexao(con);
		if (reseltado != null) {
			return reseltado;
		} else {
			return null;

		}

	}
}
