package br.com.alura.aluraforum.DTOS

import br.com.alura.aluraforum.model.Resposta
import br.com.alura.aluraforum.model.Topico
import br.com.alura.aluraforum.model.Usuario
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDateTime
import java.util.ArrayList

data class RespostaAtlzForm (
    var id: Long,
    @field:NotNull(message = "Id do topico não pode ser vazio !")
    var topico: Long,
    @field: NotEmpty(message = " Mensagem não pode ser vazia!")
    val mensagem: String,
    @field: NotNull (message = "Id Autor não pode ser vazia!")
    var status: Boolean
)

