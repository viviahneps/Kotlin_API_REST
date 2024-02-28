package br.com.alura.aluraforum.controller

import br.com.alura.aluraforum.DTOS.*
import br.com.alura.aluraforum.Service.RespostaService
import io.swagger.v3.oas.annotations.Operation
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/respostas")
class RespostaController (private val service: RespostaService) {

    @Operation(summary = "Obtem lista de Respostas para o tópico")
    @GetMapping
    fun listaResposta(): List<RespostaView> {
        return service.listaResposta()
    }

    @Operation(summary = "Efetua cadastro de Resposta para o topico")
    @PostMapping
    @Transactional
    fun cadastrarResposta(
        @RequestBody @Valid dto: RespostaForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<RespostaView>{
        val respostaView = service.cadastrarResposta(dto)
        val uri = uriBuilder.path("/respostas/${respostaView.id}").build().toUri()
        return ResponseEntity.created(uri).body(respostaView)
    }


}