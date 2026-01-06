package com.costadev.bff_agendadortarefas.infrastructure.client;


import com.costadev.bff_agendadortarefas.business.dto.out.TarefasDTOResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    void enviarEmail (@RequestBody TarefasDTOResponse dtoResponse);
}




