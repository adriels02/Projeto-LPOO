package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import core.UsuarioTransferencia;

public class UsuarioConexao {
	PreparedStatement informacoesUsuario;		
	Connection conexao;
	
	
	public ResultSet autenticacaoUsuario(UsuarioTransferencia objUsuarioTransferencia) {
		String sql = "select *from Usuario where nomeUsuario = ? and senhaUsuario = ?";
		conexao = new AcessoBancodeDados().conexaoBD();
		
		
		try {
			informacoesUsuario = conexao.prepareStatement(sql);
			informacoesUsuario.setString(1, objUsuarioTransferencia.getNomeUsuario());
			informacoesUsuario.setString(2, objUsuarioTransferencia.getSenhaUsuario());
			
			
			ResultSet resultado = informacoesUsuario.executeQuery();
			return resultado;
			
			
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "Erro em UsuarioConexao " + e);
			JOptionPane.showMessageDialog( null, "Erro ao tentar conectar o usuário", "Mensagem",JOptionPane.ERROR_MESSAGE);
			return null;
		
		}
							
			
	}
	
	public void inserirUsuario(UsuarioTransferencia objUsuarioTransferencia) {
		String sql = "insert into Usuario(nomeUsuario, senhaUsuario) values (?,?)";
		conexao = new AcessoBancodeDados().conexaoBD();
		
		
		try {
			informacoesUsuario = conexao.prepareStatement(sql);
			informacoesUsuario.setString(1, objUsuarioTransferencia.getNomeUsuario());
			informacoesUsuario.setString(2, objUsuarioTransferencia.getSenhaUsuario());
			
			
			informacoesUsuario.execute();
			informacoesUsuario.close();
			
				
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "Erro em AlterarNovoUsuario " + e);
			JOptionPane.showMessageDialog( null, "Erro ao inserir um novo usuário", "Mensagem",JOptionPane.ERROR_MESSAGE);
		    
			
			
		}
		
	
	}
	

	

}
