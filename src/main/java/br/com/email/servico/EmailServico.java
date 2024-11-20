package br.com.email.servico;

import br.com.email.DTO.EmailDTO;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class EmailServico {

    private final JavaMailSender sender;

    public void enviarEmail(EmailDTO emailDTO){
        try {
            MimeMessage mensagem = sender.createMimeMessage();
            MimeMessageHelper ajuda = new MimeMessageHelper(mensagem,true);
            ajuda.setFrom("noreply@gmail.com");
            ajuda.setSubject("Dev Carlos");
            ajuda.setTo(emailDTO.email());
            String template = exibirTemplate();
            template =  template.replace("#{nome}",emailDTO.nome());
            ajuda.setText(template,true);
            sender.send(mensagem);
        }catch(Exception ex){
            System.out.println("Falha ao enviar email");
        }
    }

    public String exibirTemplate() throws IOException {
        ClassPathResource recurso = new ClassPathResource("template-email.html");
        return new String(recurso.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
