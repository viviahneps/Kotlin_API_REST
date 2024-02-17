package br.com.alura.aluraforum.Service

import br.com.alura.aluraforum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (var autores: List<Usuario>){
    init {
        val autor = Usuario(
                id =1,
            nome= "Junior Lins",
            email = "jrLns@teste.com.br"

        )
        val autor2 = Usuario(

            id =2,
            nome= "Maria Souza",
            email = "mariaSZ@teste.com.br"

        )

        autores= Arrays.asList(autor,autor2)
    }

    fun buscaautoresId(id: Long): Usuario {
        return autores.stream().filter({
                a -> a.id ==id
        }).findFirst().get()
    }
}