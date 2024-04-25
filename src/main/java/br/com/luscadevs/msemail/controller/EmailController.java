package br.com.luscadevs.msemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.luscadevs.msemail.model.EmailComProcesso;
import br.com.luscadevs.msemail.service.EmailService;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public void sendEmail(@RequestBody EmailComProcesso emailComProcesso) {
        try {
            emailService.sendEmail(emailComProcesso);
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }
}
