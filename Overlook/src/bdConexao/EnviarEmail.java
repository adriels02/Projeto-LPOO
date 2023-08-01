package bdConexao;

import java.util.Properties;
import javax.swing.JOptionPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;


import cadastroBD.CadastroClienteDAO;


public class EnviarEmail extends CadastroClienteDAO  {


	public static void main(String[] args) {
		String meuEmail  = "hoteloverlookgerenciamento@gmail.com";
		String minhaSenha = "rbppfjleucaqukik";
		
	    String enviarPara = "hoteloverlookgerenciamento@gmail.com";
		
		
		
        Properties propriedades = System.getProperties();
		
        propriedades.put("mail.smtp.host", "smtp.gmail.com");
        propriedades.put("mail.smtp.port", "465");
        propriedades.put("mail.smtp.starttls.enable", "true");
        propriedades.put("mail.smtp.auth", "true");
        propriedades.put("mail.smtp.ssl.protocols", "TLSv1.2");


		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator (meuEmail,minhaSenha));
		email.setSSLOnConnect(true);
	
		 try {
			email.setFrom(meuEmail);
			email.setSubject("Confirmação de Pagamento"); //titulo do e-mail
			email.setMsg("Sua compra foi efetivada com sucesso! Informações do pedido segue em anexo. Para qualquer dúvida ou problema contactar-nos através deste e-mail"); //corpo da mensagem
			email.addTo(enviarPara); //o email para o quem eu quero enviar
			email.send(); //efetuar envio
			System.out.println("Email enviado com sucesso");
		
		 } catch (Exception e) {
		
			 JOptionPane.showMessageDialog(null, e.getMessage());
		
		}
	
	
	}

}



