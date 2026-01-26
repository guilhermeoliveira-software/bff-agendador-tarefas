package com.costadev.bff_agendadortarefas.infrastructure.client;


import com.costadev.bff_agendadortarefas.business.dto.out.TarefasDTOResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
    void enviarEmail (@RequestBody TarefasDTOResponse dtoResponse);
}




