package com.costadev.bff_agendadortarefas.controller;


import com.costadev.bff_agendadortarefas.business.TarefasService;
import com.costadev.bff_agendadortarefas.business.dto.in.TarefasDTORequest;
import com.costadev.bff_agendadortarefas.business.dto.out.TarefasDTOResponse;
import com.costadev.bff_agendadortarefas.business.enums.StatusNotificacaoEnum;
import com.costadev.bff_agendadortarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Cadastro de Tarefas de Usuarios")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salvar Tarefas de Usuarios", description = "Criar uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefas(token, dto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca Tarefas por Período", description = "Busca tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token){

        return ResponseEntity.ok(tarefasService.buscarTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Busca lista de Tarefas por Email de Usuario",
            description = "Busca tarefas cadastradas por email")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Email não encontrada.")
    @ApiResponse(responseCode = "401", description = "Usuario não autorizado.")
    public ResponseEntity<List<TarefasDTOResponse>> buscarTarefasPorEmail(
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.buscarTarefasPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deleta Tarefas por Id", description = "Deleta tarefas cadastradas por Id")
    @ApiResponse(responseCode = "200", description = "Tarefas deletadas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa Id não encontrada.")
    @ApiResponse(responseCode = "401", description = "Usuario não autorizado.")
    public ResponseEntity<Void> deletaTarefasPorId(@RequestParam("id") String id,
                                                   @RequestHeader(name = "Authorization", required = false) String token) {
                tarefasService.deletarTabelaPorId(id, token);
                return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status da Tarefas", description = "Altera stauts da tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Status da Tarefas alteradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa Id não encontrada.")
    @ApiResponse(responseCode = "401", description = "Usuario não autorizado.")
    public ResponseEntity<TarefasDTOResponse> alteraStatusNotificacao(@RequestParam ("Status") StatusNotificacaoEnum status,
                                                                      @RequestParam ("id") String id,
                                                                      @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.alterarStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados da Tarefas", description = "Altera dados da tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefas alteradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa Id não encontrada.")
    @ApiResponse(responseCode = "401", description = "Usuario não autorizado.")
    public ResponseEntity<TarefasDTOResponse> updateTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestHeader("id") String id,
                                                            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.updateTarefas(dto, id, token));
    }
}
