package com.costadev.bff_agendadortarefas.business;

import com.costadev.bff_agendadortarefas.business.dto.in.EnderecoDTORequest;
import com.costadev.bff_agendadortarefas.business.dto.in.LoginDTORequest;
import com.costadev.bff_agendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.costadev.bff_agendadortarefas.business.dto.in.TelefoneDTORequest;
import com.costadev.bff_agendadortarefas.business.dto.in.UsuarioDTORequest;
import com.costadev.bff_agendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTORequest salvarUsuario(UsuarioDTORequest usuarioDTO) {
        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest usuarioDTO) {
        return client.loginUsuario(usuarioDTO);
    }

    public UsuarioDTORequest buscaUsuarioPorEmail(String email, String token) {
        return client.buscarUsuarioPorEmail(email, token);
    }

    public void deletarUsuarioPorEmail(String email, String token) {
        client.deletarPorEmail(email, token);
    }

    public UsuarioDTORequest atualizarDadosUsuario(String token, UsuarioDTORequest dto) {
        return client.atualizaDadosUsuario(token, dto);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest dto, String token) {
        return client.atualizaEndereco(dto, idEndereco, token);
    }

    public TelefoneDTORequest atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token) {
        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTOResponse cadastroEndereco(String token, EnderecoDTORequest dto) {
        return client.cadastroEndereco(token, dto);
    }

    public TelefoneDTORequest cadastroTelefone(String token, TelefoneDTORequest dto) {
        return client.cadastroTelefone(token, dto);
    }
}
