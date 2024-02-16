package br.com.alura.aluraforum.controller

import br.com.alura.aluraforum.Service.TopicoService
import br.com.alura.aluraforum.model.Curso
import br.com.alura.aluraforum.model.Topico
import br.com.alura.aluraforum.model.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping ("/topicos")
class TopicoController(private val service: TopicoService) {
   @GetMapping
  fun listar(): List<Topico> {
       return service.listar()
   }

    @GetMapping ("/{id}")
  fun buscaId(@PathVariable id: Long): Topico{
   return service.buscarporId(id)
  }
}
