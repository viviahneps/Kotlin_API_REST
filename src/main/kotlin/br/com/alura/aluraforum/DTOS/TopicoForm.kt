package br.com.alura.aluraforum.DTOS


import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


class TopicoForm (
        var id: Long? = null,
        @field: NotEmpty @Size(min =5 ,  max =100, message = "Titulo não pode ser vazio !" )
        var titulo: String,
        @field: NotEmpty (message = "Mensagem não pode ser vazia!")
        val mensagem: String,
        @field: NotNull
        val idcurso: Long,
        @field:NotNull
        val idautor: Long,

        )
