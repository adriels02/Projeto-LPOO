package bdConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bdTransferencia.UsuarioTransferencia;

public class UsuarioConexao {
	
	Connection conexao;
	
	public ResultSet autenticacaoUsuario(UsuarioTransferencia objUsuarioTransferencia) {
		conexao = new AcessoBancodeDados().conexaoBD();
		
		
		try {
			String sql = "select *from Usuario where nomeUsuario = ? and senhaUsuario = ?";
			PreparedStatement informacoesUsuario = conexao.prepareStatement(sql);
			informacoesUsuario.setString(1, objUsuarioTransferencia.getNomeUsuario());
			informacoesUsuario.setString(2, objUsuarioTransferencia.getSenhaUsuario());
			
			ResultSet resultado = informacoesUsuario.executeQuery();
			return resultado;
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em UsuarioConexao " + e);
			return null;
			
						
			
		}
		
			
	}
	

}
