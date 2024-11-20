package br.com.email.controle;

import br.com.email.DTO.EmailDTO;
import br.com.email.servico.EmailServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("email")
@RequiredArgsConstructor
public class EmailControle {

    private final EmailServico servico;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Endpoint responsável por enviar email.")
    @ApiResponse(responseCode = "201",description = "Email enviado com sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public void enviarEmail(@RequestBody EmailDTO emailDTO){
        servico.enviarEmail(emailDTO);
    }
}
