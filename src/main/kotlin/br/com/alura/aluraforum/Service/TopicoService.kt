package br.com.alura.aluraforum.Service

import br.com.alura.aluraforum.model.Curso
import br.com.alura.aluraforum.model.Topico
import br.com.alura.aluraforum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService (private var topicos: List<Topico>){
    init {
        val topico = Topico(
            id=1,
            titulo="Erro kotlin class main",
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
        val topico2 = Topico(
            id=2,
            titulo="Erro Kotlin class Main",
            mensagem="Como aprender API REST",
            curso = Curso(
                id = 1,
                nome="Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id =2,
                nome= "Maria Souza",
                email = "mariaSZ@teste.com.br"
            )
        )
        val topico3 = Topico(
            id=3,
            titulo="Erro Kotlin class Main",
            mensagem="Como aprender API REST",
            curso = Curso(
                id = 1,
                nome="Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id =2,
                nome= "Luna Souza",
                email = "moon@teste.com.br"
            )
        )
        topicos= Arrays.asList(topico,topico2,topico3)
    }

    fun listar(): List<Topico> {
     return topicos

    }

    fun buscarporId(id: Long): Topico {
        return topicos.stream().filter({
          t->t.id==id
        }).findFirst().get()

    }


}
