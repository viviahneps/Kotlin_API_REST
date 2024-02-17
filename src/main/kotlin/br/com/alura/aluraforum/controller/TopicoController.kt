package br.com.alura.aluraforum.controller

import br.com.alura.aluraforum.DTOS.TopicoForm
import br.com.alura.aluraforum.DTOS.TopicoView
import br.com.alura.aluraforum.Service.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

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
    fun cadastrar(@RequestBody @Valid dto:TopicoForm){
        service.cadastrar(dto)

    }
}
