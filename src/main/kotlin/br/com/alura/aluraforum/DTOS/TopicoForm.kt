package br.com.alura.aluraforum.DTOS


import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


class TopicoForm (
        var id: Long? ,
        @field: NotEmpty (message = " Titulo não pode ser vazio !" )
        @field: Size(min =5 ,  max =100, message = " Titulo deve ter entre 5 e 100 caracteres !" )
        var titulo: String,
        @field: NotEmpty (message = " Mensagem não pode ser vazia!")
        val mensagem: String,
        @field: NotNull (message = " Id do curso não pode ser vazio !")
        val idcurso: Long,
        @field:NotNull (message = "Id do autor não pode ser vazio !")
        val idautor: Long,

        )
