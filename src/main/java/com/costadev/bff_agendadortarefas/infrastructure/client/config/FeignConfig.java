package com.costadev.bff_agendadortarefas.infrastructure.client.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    public FeignError feignError(){
        return new FeignError();
    }
}
