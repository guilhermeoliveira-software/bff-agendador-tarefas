package com.costadev.bff_agendadortarefas.infrastructure.client.config;

import com.costadev.bff_agendadortarefas.infrastructure.exceptions.*;
import com.costadev.bff_agendadortarefas.infrastructure.exceptions.IllegalArgumentException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.util.Objects;

public class FeignError implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {

        String mensagemErro = mensagemErro(response);
        String mensagem = "Erro: ";

        switch (response.status()) {
            case 409:
                return new ConflictException(mensagem + mensagemErro);
            case 403:
                return new ResourceNotFoundException(mensagem + mensagemErro);
            case 401:
                return new UnauthorizedException(mensagem + mensagemErro);
            case 400:
                return new IllegalArgumentException(mensagem + mensagemErro);
            default:
                return new BusinessException(mensagem + mensagemErro);
        }

    }


    private String mensagemErro(Response response) {

        try {
            if (Objects.isNull(response.body())){
                return "";
            }
            String mensagemError = new String(response.body().asInputStream().readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
