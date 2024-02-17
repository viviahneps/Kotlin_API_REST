package br.com.alura.aluraforum.DTOS

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicoAtlzForm (
    @field: NotNull
    val id:Long,
    @field: NotEmpty
    @field:Size(min = 5, max =100)
    val titulo : String,
    @field: NotEmpty
    val mensagem: String
        )


