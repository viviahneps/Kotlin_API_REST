package br.com.alura.aluraforum.controller

import br.com.alura.aluraforum.DTOS.TopicoAtlzForm
import br.com.alura.aluraforum.DTOS.TopicoForm
import br.com.alura.aluraforum.DTOS.TopicoView
import br.com.alura.aluraforum.Service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping ("/topicos")
class TopicoController(private val service: TopicoService) {
   @GetMapping
  fun listar(): List<TopicoView> {
       return service.listar()
   }

    @GetMapping ("/{id}")
    //Path indica que o parametro vem no endpoint
   fun buscaId(@PathVariable id: Long): TopicoView{
   return service.buscarporId(id)
  }


    @PostMapping
    //RequestBody indica que o parametro vem pelo corpo da mensagem
    fun cadastrar(@RequestBody @Valid dto:TopicoForm,
                  uriBuilder:UriComponentsBuilder
        ) : ResponseEntity<TopicoView>{
        val topicoView = service.cadastrar(dto)
        val uri =uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun atualilzar(@RequestBody @Valid form: TopicoAtlzForm) : ResponseEntity<TopicoView>{
     val topicoView = service.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }
    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable  id: Long){
        service.deletar(id)
    }
}
