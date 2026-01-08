package com.costadev.bff_agendadortarefas.business;

import com.costadev.bff_agendadortarefas.business.dto.in.LoginDTORequest;
import com.costadev.bff_agendadortarefas.business.dto.out.TarefasDTOResponse;
import com.costadev.bff_agendadortarefas.business.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;
    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefaProximaPorHora(){
        String token = login(coverterParaDTORequest());

        log.info("Iniciada a busca de Tarefas");
        LocalDateTime horaAtual = LocalDateTime.now();
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);

        List<TarefasDTOResponse> listaTarefa= tarefasService.buscarTarefasAgendadasPorPeriodo(horaAtual,horaFutura,token);

        log.info("Tarefas encontradas" + listaTarefa);
        listaTarefa.forEach(tarefa -> {
            log.info("Email enviado para o usuario" + tarefa.getEmailUsuario());
            emailService.enviaEmail(tarefa);
            tarefasService.alterarStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(),
                    token);});
        log.info("Finalizada a busca e notificação de tarefas");

    }

    public String login(LoginDTORequest dtoRequest){
        return usuarioService.loginUsuario(dtoRequest);
    }

    public LoginDTORequest coverterParaDTORequest(){
        return LoginDTORequest.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
