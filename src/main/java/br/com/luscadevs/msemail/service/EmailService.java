package br.com.luscadevs.msemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import br.com.luscadevs.msemail.model.EmailComProcesso;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendEmail(EmailComProcesso email) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom("no-reply@meusprocessos.com");
        helper.setTo(email.email().to());
        helper.setSubject(email.email().subject());

        // Processa o template Thymeleaf
        Context context = new Context();
        // Adicione quaisquer variáveis que você queira passar para o template aqui
        // Por exemplo, context.setVariable("nome", "Valor");
        context.setVariable("processo", email.processo());
        String htmlContent = templateEngine.process("email-template", context);

        helper.setText(htmlContent, true);

        javaMailSender.send(mimeMessage);
    }
}
