package com.costadev.bff_agendadortarefas.business.dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTOResponse {

    private Long id;
    private Long numero;
    private String rua;
    private Integer cep;
    private String cidade;
    private String estado;
    private String complemento;
}
