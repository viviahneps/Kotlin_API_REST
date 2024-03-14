package br.com.alura.aluraforum.controller

import br.com.alura.aluraforum.DTOS.*
import br.com.alura.aluraforum.Service.RespostaService
import io.swagger.v3.oas.annotations.Operation
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/respostas")
class RespostaController (private val service: RespostaService) {

    @Operation(summary = "Lista respostas cadastradas")
    @GetMapping
    fun listaResposta(
        @RequestParam(required = false ) idTopico : Long?,
        @PageableDefault(size= 5, sort = ["dataCriacao"], direction = Sort.Direction.DESC) paginacao: Pageable
    ): Page<RespostaView> {
        return service.listarResposta(idTopico,paginacao)
    }

    @Operation(summary = "Cadastra resposta para o tópico")
    @PostMapping
    @Transactional
    fun cadastrarResposta(
        @RequestBody @Valid dto: RespostaForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<RespostaView>{
        val respostaView = service.cadastrarResposta(dto)
        System.out.println("Dados recebidos no Controller: " +respostaView)
        val uri = uriBuilder.path("/respostas/${respostaView.id}").build().toUri()
        return ResponseEntity.created(uri).body(respostaView)
    }

    @Operation(summary = "Atualiza dados e status da resposta")
    @PutMapping
    @Transactional
    fun atualilzarResposta(@RequestBody @Valid form: RespostaAtlzForm) : ResponseEntity<RespostaView>{
        val respostaView = service.atualizarResposta(form)
        return ResponseEntity.ok(respostaView)
    }


}