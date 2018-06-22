package application;

import javax.swing.JOptionPane;

import helpers.SaqueHelper;

public class Caixa {

	
	public static void main(String[] args) {
		
		int repetir = 0;
		
		do {
			SaqueHelper saqueHelper = new SaqueHelper();

			Double valorDoSaque = 0.0;
			String mensagemDeSaque = ""; 
			String mensagemDeConfirmacao = "Deseja realizar outro saque?";
			
			do {
				
				try {
					valorDoSaque = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja sacar?"));
				}catch (NumberFormatException numberFormatException) {
					JOptionPane.showMessageDialog(null, "Digite um valor em números");
				}catch(NullPointerException nullPointerException) {
					JOptionPane.showMessageDialog(null, "Obrigado pela paciência!", "Volte sempre.", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			
			}while(valorDoSaque == 0.0);
	
			
			if (valorDoSaque % 10 == 0) mensagemDeSaque = saqueHelper.efetuaSaque(valorDoSaque);
			else mensagemDeSaque = saqueHelper.verificaValor(valorDoSaque);
			
			
			repetir = JOptionPane.showConfirmDialog(null, mensagemDeSaque + mensagemDeConfirmacao,
						"Deseja continuar utilizando o sistema?", JOptionPane.YES_NO_OPTION);
			
		}while(repetir == 0);
		
		JOptionPane.showMessageDialog(null, "Obrigado pela paciência!", "Volte sempre.",
					JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	
}
