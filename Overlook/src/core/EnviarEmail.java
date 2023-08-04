package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import data.CadastroClienteDAO;

public class EnviarEmail extends CadastroClienteDAO {

    public static void main(String[] args) {
        String meuEmail = "hoteloverlookgerenciamento@gmail.com";
        String minhaSenha = "rbppfjleucaqukik";

        Properties propriedades = System.getProperties();

        propriedades.put("mail.smtp.host", "smtp.gmail.com");
        propriedades.put("mail.smtp.port", "465");
        propriedades.put("mail.smtp.starttls.enable", "true");
        propriedades.put("mail.smtp.auth", "true");
        propriedades.put("mail.smtp.ssl.protocols", "TLSv1.2");

        String url = "jdbc:mysql://db4free.net:3306/overlook_db";
        String usuario = "overlook_user";
        String senha = "#BDhotel123";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            String query = "SELECT email FROM Cliente where cpf = ?";
            Statement stmt = conexao.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                String enviarPara = resultSet.getString("email");

                SimpleEmail email = new SimpleEmail();
                email.setHostName("smtp.gmail.com");
                email.setSmtpPort(465);
                email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
                email.setSSLOnConnect(true);

                email.setFrom(meuEmail);
                email.setSubject("Confirmação de Pagamento");
                email.setMsg("Sua compra foi efetivada com sucesso! Informações do pedido seguem em anexo. Para qualquer dúvida ou problema contactar-nos através deste e-mail");
                email.addTo(enviarPara);

                email.send();
                System.out.println("E-mail enviado para: " + enviarPara);
            }

            resultSet.close();
            stmt.close();
            conexao.close();

        } catch (SQLException | EmailException e) {
        	JOptionPane.showMessageDialog( null, "E-mail não enviado", "Mensagem",JOptionPane.ERROR_MESSAGE);
           
        }
    }
}