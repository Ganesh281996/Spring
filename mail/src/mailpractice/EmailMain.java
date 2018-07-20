package mailpractice;

import java.util.Properties;

import javax.mail.Session;


public class EmailMain 
{	
	public static void main(String[] args) 
	{	
	    System.out.println("SimpleEmail Start");
		
	    String smtpHostServer = "smtp.example.com";
	    String emailID = "email_me@example.com";
	    
	    Properties props = System.getProperties();

	    props.put("mail.smtp.host", smtpHostServer);

	    Session session = Session.getInstance(props, null);
	    
	    SendEmail.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}
}