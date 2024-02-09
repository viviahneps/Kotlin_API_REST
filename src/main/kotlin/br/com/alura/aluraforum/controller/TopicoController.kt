package br.com.alura.aluraforum.controller

import br.com.alura.aluraforum.model.Curso
import br.com.alura.aluraforum.model.Topico
import br.com.alura.aluraforum.model.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping ("/topicos")
class TopicoController {
   @GetMapping
  fun listar(): List<Topico>{
       val topico =Topico(
         id=1,
         titulo="Aprendendo API",
         mensagem="Como aprender API REST",
              curso = Curso(
                  id = 1,
                  nome="Kotlin",
                  categoria = "Programação"
              ),
           autor = Usuario(
               id =1,
               nome= "Junior Lins",
               email = "jrLns@teste.com.br"
           )
       )
  return Arrays.asList(topico,topico)
  }

}
