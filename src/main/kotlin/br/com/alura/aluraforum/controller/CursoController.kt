package br.com.alura.aluraforum.controller

import br.com.alura.aluraforum.DTOS.*
import br.com.alura.aluraforum.Service.CursoService
import io.swagger.v3.oas.annotations.Operation
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/cursos")
class CursoController (private val service: CursoService ) {

        @Operation(summary = "Obtem lista de cursos")
        @GetMapping
        fun listarCurso(): List<CursoView> {
            return service.listarCurso()
        }

       @Operation(summary = "Efetua cadastro de tópico")
       @PostMapping
       @Transactional
      //RequestBody indica que o parametro vem pelo corpo da mensagem
        fun cadastrarCurso(@RequestBody @Valid cdto: CursoForm,
                  uriBuilder: UriComponentsBuilder
         ) : ResponseEntity<CursoView> {
          val cursoView = service.cadastrarCurso(cdto)
          val uri =uriBuilder.path("/cursos/${cursoView.id}").build().toUri()
          return ResponseEntity.created(uri).body(cursoView)
    }



}