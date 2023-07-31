package bdConexao;

import javax.mail.Authenticator;

/*import java.util.Properties;
import javax.activation.*;
import javax.mail.*;

import javax.mail.internet.*;*/
import javax.swing.JOptionPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail {

	public static void main(String[] args) {
		String meuEmail  = "Emailque.vai.enviar@gmail.com";
		String minhaSenha = "senha do e-mail";
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator (meuEmail,minhaSenha));
		email.setSSLOnConnect(true);
	
		 try {
			email.setFrom(meuEmail);
			email.setSubject("Assunto");
			email.setMsg("a mensagem");
			email.addTo(meuEmail); //o email para qual quer enviar
			email.send();
			System.out.println("Email enviado com sucesso");
		
		 } catch (Exception e) {
			 JOptionPane.showMessageDialog(null, e.getMessage());
			//e.printStackTrace();
		}
	
	
	}

}
