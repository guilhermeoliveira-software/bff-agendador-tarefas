package com.costadev.bff_agendadortarefas.infrastructure.client;


import com.costadev.bff_agendadortarefas.business.dto.in.EnderecoDTORequest;
import com.costadev.bff_agendadortarefas.business.dto.in.LoginDTORequest;
import com.costadev.bff_agendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.costadev.bff_agendadortarefas.business.dto.in.TelefoneDTORequest;
import com.costadev.bff_agendadortarefas.business.dto.in.UsuarioDTORequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTORequest buscarUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);


    @PostMapping
    UsuarioDTORequest salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/login")
    String loginUsuario(@RequestBody LoginDTORequest usuarioDTO,
                        @RequestHeader("Authorization") String token);

    @GetMapping
    public UsuarioDTORequest buscarPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @DeleteMapping("/{email}")
    void deletarPorEmail(@PathVariable String email,
                         @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTORequest atualizaDadosUsuario(@RequestHeader("Authorization") String token,
                                           @RequestBody UsuarioDTORequest dto);

    @PutMapping("/enderecos")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);


    @PutMapping("/telefones")
    TelefoneDTORequest atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                        @RequestParam("id") Long id,
                                        @RequestHeader("Authorization") String token);


    @PostMapping("/enderecos")
    EnderecoDTOResponse cadastroEndereco(@RequestHeader("Authorization") String token,
                                         @RequestBody EnderecoDTORequest dto
    );

    @PostMapping("/telefones")
    TelefoneDTORequest cadastroTelefone(@RequestHeader("Authorization") String token,
                                        @RequestBody TelefoneDTORequest dto
    );

}




