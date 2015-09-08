package startek.service;

import java.io.StringWriter;
import java.util.Date;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import startek.entity.AppUser;
import startek.entity.NotificationType;
import startek.entity.Notifications;
import startek.util.Mail;
import startek.util.Util;

@Service
public class MailerService {

	@Autowired
	Environment env;
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;
	@Autowired
	private VendorsService vendorsService;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	
	/**
	 * Dynamic mail sender request caller feed it HTML text and it will send it
	 * @param mail
	 * @param txt
	 */
	public void sendHtml(final Mail mail,final String txt) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
		
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(mail.getMailTo());
				message.setFrom(new InternetAddress(mail.getMailFrom()));
				message.setSubject(mail.getMailSubject());
				message.setSentDate(new Date());
		
				System.out.println("Sending the Composed msg");				
			
				message.setText(txt, true);
			}
		};
		   mailSender.send(preparator);
	}

	public void sendMail(Mail mail) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(mail.getMailFrom());
		message.setTo(mail.getMailTo());
		message.setSubject(mail.getMailSubject());

		Template template = velocityEngine.getTemplate("./templates/"
				+ mail.getTemplateName());

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("firstName", "Niwogaba");
		velocityContext.put("lastName", "Joel");
		velocityContext.put("location", "Busker Bucky");

		StringWriter stringWriter = new StringWriter();

		template.merge(velocityContext, stringWriter);

		String txt = stringWriter.toString();
		System.out.println("Sending this Stuff :" + txt);
		message.setText(txt);

		mailSender.send(message);

	}

	public void sendHtml(final Mail mail) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
		
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(mail.getMailTo());
				message.setSubject(mail.getMailSubject());
				

				message.setFrom(new InternetAddress(mail.getMailFrom()));
				message.setSentDate(new Date());
				
				Template template = velocityEngine.getTemplate("./templates/"
						+ mail.getTemplateName());

				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("firstName", "Niwogaba");
				velocityContext.put("lastName", "Joel");
				velocityContext.put("location", "Busker Bucky");

				StringWriter stringWriter = new StringWriter();

				template.merge(velocityContext, stringWriter);

				String txt = stringWriter.toString();
				System.out.println("Sending this Stuff :" + txt);				
			
				message.setText(txt, true);
			}
		};
		   mailSender.send(preparator);
	}

	/**
	 * Create html from template
	 * @param templateName
	 * @param data
	 * @return
	 */
	public String composeFeedBackHtml(String templateName,Map<String,Object> data) {
		Template template = velocityEngine.getTemplate("./templates/"+ templateName);
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("content",data );
		velocityContext.put("currentDate", new Date());
	
		
		StringWriter stringWriter = new StringWriter();

		template.merge(velocityContext, stringWriter);

		String txt = stringWriter.toString();
		System.out.println("Sending this Stuff :" + txt);	
		return txt;
	}

	/**
	 * Process a local copy of the 
	 * @param workRequest
	 * @param mail
	 * @param user
	 */
	public void saveProcessWorkRequest(NotificationType workRequest, Mail mail,String fullname,AppUser user) {
		String link =Util.BASE_URL+"/app/user/"+user.getUsername();
		Notifications nofication = new Notifications(workRequest,link, null,mail.getMailSubject(),"You have received an new Work Request from "+fullname, new Date());
		

		vendorsService.saveNotification(user,nofication);
		
	}
	

}
