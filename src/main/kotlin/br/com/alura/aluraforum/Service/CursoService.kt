package br.com.alura.aluraforum.Service

import br.com.alura.aluraforum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService (var cursos: List<Curso>){

    init {
        val curso = Curso(
                id = 1,
                nome="Kotlin",
                categoria = "Programação"
            )
        val curso2 = Curso(

            id = 2,
            nome="API",
            categoria = "REST"
        )

        cursos= Arrays.asList(curso,curso2)
    }

    fun buscacursoId(id: Long):Curso{
       return cursos.stream().filter ({
         c -> c.id == id
          }).findFirst().get()
      }

}