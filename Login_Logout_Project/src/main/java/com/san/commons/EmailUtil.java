package com.san.commons;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailUtil {
	

	@Autowired
	private JavaMailSender sender;

	public boolean sendEmail(String to, String subject, String text, String[] cc, String[] bcc, MultipartFile file) {
		boolean flag = false;
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, file != null);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			if (cc != null)
				helper.setCc(cc);
			if (bcc != null)
				helper.setCc(bcc);

			if (file != null) {
				helper.addAttachment(file.getOriginalFilename(), file);
			}
			sender.send(message);

			flag = true;

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}
}