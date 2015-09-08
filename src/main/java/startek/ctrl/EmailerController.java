package startek.ctrl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import startek.entity.AppUser;
import startek.entity.NotificationType;
import startek.entity.WeddingPost;
import startek.entity.WorkRequest;
import startek.service.MailerService;
import startek.service.UserService;
import startek.service.VendorsService;
import startek.util.Mail;
import startek.util.Util;

@Controller
public class EmailerController {

	@Autowired
	Mail mail;

	@Autowired
	private MailerService mailerService;
	@Autowired
	private VendorsService vendorsService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/vendoralert")
	public @ResponseBody String sendFeedBack(

	@RequestParam("email") String email,
			@RequestParam("username") String username,
			@RequestParam("subject") String subject,
			@RequestParam("body") String body, HttpServletRequest request) {

		final String ctx = request.getContextPath();

		final Map<String, Object> map = new HashMap<String, Object>();

		try {
			Mail mail = new Mail();
			mail.setMailTo(email);
			mail.setMailSubject(subject);
			mail.setMailName(subject);
			mail.setTemplateName("vendors-newletter-product-listing.vm");

			// data

			map.put("email", email);
			map.put("username", username);
			map.put("subject", subject);
			map.put("body", body);
			AppUser user = userService.findOneByUsername(username);
			if (user == null) {
				return Util.metaRefreshHtml("Send message to the vendor . .",
						ctx + "/dashboard.html", "Failed to find user");
			}

			List<WeddingPost> posts = vendorsService.findPostByAppUser(user, 0,
					15);
			map.put("posts", posts);

			String text = mailerService.composeFeedBackHtml(
					mail.getTemplateName(), map);

			mailerService.sendHtml(mail, text);

			return Util.metaRefreshHtml("Send message to the vendor . .",
					"/dashboard.html", "Message has been sent successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Util.metaRefreshHtml("Send message to the vendor . .", ctx
					+ "/dashboard.html", "Failed to send message");
		}

	}

	@RequestMapping(value = "/sendfeedback")
	public @ResponseBody String sendFeedBack(
			@RequestParam("fullname") String fullname,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("username") String username,
			@RequestParam("subject") String subject,
			@RequestParam("body") String body, HttpServletRequest request) {

		final String ctx = request.getContextPath();

		final Map<String, Object> map = new HashMap<String, Object>();

		try {
			Mail mail = new Mail();
			mail.setMailTo("weddings101wire@gmail.com");
			mail.setMailSubject(subject);
			mail.setMailName("The Wedding Wolf Market Place");
			mail.setTemplateName("user-feedback-email.vm");

			// data
			map.put("fullname", fullname);
			map.put("email", email);
			map.put("phone", phone);
			map.put("username", username);
			map.put("subject", subject);
			map.put("body", body);

			String text = mailerService.composeFeedBackHtml(
					mail.getTemplateName(), map);

			mailerService.sendHtml(mail, text);

			return Util.metaRefreshHtml(
					"Send message to the wedding wolf team. .", ctx
							+ "/dashboard.html",
					"Message has been sent successfully");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Util.metaRefreshHtml(
					"Send message to the wedding wolf team. . .", ctx
							+ "/dashboard.html", "Failed to send message");

		}

	}

	/**
	 * Send the Request to the vendor
	 * 
	 * @param fullname
	 * @param email
	 * @param phone
	 * @param username
	 * @param subject
	 * @param body
	 * @param location
	 * @param people
	 * @param weddingday
	 * @return
	 */
	@RequestMapping(value = "/contact-vendor")
	public @ResponseBody String contactServiceProvider(
			@RequestParam("fullname") String fullname,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("username") String username,
			@RequestParam("subject") String subject,
			@RequestParam("body") String body,
			@RequestParam("location") String location,
			@RequestParam("people") String people,
			@RequestParam("weddingday") String weddingday) {
		System.out.println("Selected Date >>" + weddingday);
		System.out.println("From Mail >>" + mail.getMailFrom());
		Date weddingdayTime = null;
		try {
			DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
			weddingdayTime = df.parse(weddingday);
			String newDateString = df.format(weddingdayTime);
			System.out.println("Selected Date >>" + newDateString);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Selected Date >>");
			return "0";
		}

		final Map<String, Object> map = new HashMap<String, Object>();

		try {

			AppUser user = userService.findOneByUsername(username);
			if (user == null) {
				return "0";
			}

			mail.setMailTo(user.getBusinessinfo().getBusinessemail());
			mail.setMailSubject("The Wedding Wolf Service Request Message To @"
					+ user.getUsername());
			mail.setMailName("The Wedding Wolf");
			mail.setTemplateName("the-service-request-form.vm");

			// data
			map.put("fullname", fullname);
			map.put("email", email);
			map.put("phone", phone);
			map.put("username", username);
			map.put("subject", mail.getMailSubject());
			map.put("body", body);
			map.put("people", people);
			map.put("location", location);
			map.put("weddingday", weddingday);

			String text = mailerService.composeFeedBackHtml(
					mail.getTemplateName(), map);

			// process the work request before sending
			try {
				WorkRequest work = new WorkRequest(subject, body, fullname,
						phone, email, weddingdayTime, new Date(), people,
						location);
				work.setEnabled(true);

				mailerService.saveProcessWorkRequest(
						NotificationType.WORK_REQUEST, mail, fullname, user);
				vendorsService.saveWorkRequest(work, user);
			} catch (Exception e) {
				System.out.println("Failed to process work request locally");
			}

			mailerService.sendHtml(mail, text);

			return "1";

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "0";

		}

	}

	@RequestMapping(value = "/txt")
	public @ResponseBody String index() {

		try {
			Mail mail = new Mail();
			mail.setMailTo("weddings101wire@gmail.com");
			mail.setMailSubject("Subject - Send Email using Spring Velocity Template");
			mail.setMailName("The Wedding Wolf Podcast");
			mail.setTemplateName("hello.vm");
			mailerService.sendHtml(mail);

			return "Sent email ";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Not created";
		}

	}

}
