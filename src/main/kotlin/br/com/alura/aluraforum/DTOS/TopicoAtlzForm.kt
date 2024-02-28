package br.com.alura.aluraforum.DTOS

import br.com.alura.aluraforum.model.Resposta
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.util.ArrayList

data class TopicoAtlzForm (
    @field: NotNull
    val id:Long,
    @field: NotEmpty
    @field:Size(min = 5, max =100)
    val titulo : String,
    @field: NotEmpty
    val mensagem: String,
    val respostas: List<Resposta> =  ArrayList ()
        )


