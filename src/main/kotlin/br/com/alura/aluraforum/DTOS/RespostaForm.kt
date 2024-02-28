package br.com.alura.aluraforum.DTOS


import br.com.alura.aluraforum.model.Usuario
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

class RespostaForm(

    var id: Long,
    @field: NotEmpty(message = " Mensagem não pode ser vazia!")
    val mensagem: String,
    @field: NotNull (message = "Id Autor não pode ser vazia!")
    var idautor: Long,
    @field:NotNull(message = "Id do topico não pode ser vazio !")
    var topico: Long,
    var status: Boolean
    )



