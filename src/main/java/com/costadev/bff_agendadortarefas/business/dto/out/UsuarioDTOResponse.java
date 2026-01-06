package com.costadev.bff_agendadortarefas.business.dto.out;


import com.costadev.bff_agendadortarefas.business.dto.in.TelefoneDTORequest;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTOResponse {

    private String nome;
    private String email;
    private String senha;

    private List<EnderecoDTOResponse> enderecos;
    private List<TelefoneDTORequest> telefones;
}
