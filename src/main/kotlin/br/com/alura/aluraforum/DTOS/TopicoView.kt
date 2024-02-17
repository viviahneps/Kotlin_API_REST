package br.com.alura.aluraforum.DTOS

import br.com.alura.aluraforum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoView (
    var id : Long?,
    var titulo : String,
    var mensagem: String,
    var status: StatusTopico,
    var dataCriacao : LocalDateTime

        )

