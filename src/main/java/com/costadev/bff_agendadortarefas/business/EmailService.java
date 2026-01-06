package com.costadev.bff_agendadortarefas.business;

import com.costadev.bff_agendadortarefas.business.dto.out.TarefasDTOResponse;
import com.costadev.bff_agendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient client;

    public void enviaEmail(TarefasDTOResponse dto){
        client.enviarEmail(dto);
    }


}
