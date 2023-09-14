package br.com.fiap.view;

import javax.swing.JOptionPane;

import br.com.fiap.controller.CarroController;


public class ClienteView {

	public static void main(String[] args) {
		String aux, escolha = "sim", placa, cor , descricao ;
		int opcao;
		
		CarroController cliente = new CarroController();
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog("Escolha: "
						+ "\n (1) Insere "
						+ "\n (2) Altera"
						+ "\n (3) Excluir");
				opcao = Integer.parseInt(aux);
				placa = JOptionPane.showInputDialog("Placa: ");
				
				switch (opcao) {
				case 1:
					cor = JOptionPane.showInputDialog("Nome: ");
					descricao = JOptionPane.showInputDialog("Id: ");
					System.out.println(cliente.insereCarro(placa, cor, descricao));
					JOptionPane.showMessageDialog(null, cliente.listaCarro());
					break;

				case 2:
					cor = JOptionPane.showInputDialog("Nome: ");
					descricao = JOptionPane.showInputDialog("id");
					System.out.println(cliente.alterarCarro(placa, cor, descricao));
					JOptionPane.showMessageDialog(null, cliente.listaCarro());
					
					break;
					
				case 3:
					System.out.println(cliente.excluirCarro(placa));
					JOptionPane.showMessageDialog(null, cliente.listaCarro());
					break;
					
				default:
					System.out.println("Escolha incorreta");
					break;
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		escolha = (JOptionPane.showInputDialog("Deseja continuar? "));
			
		}
		JOptionPane.showMessageDialog(null, "Progama finalizado");
		
	}

}
