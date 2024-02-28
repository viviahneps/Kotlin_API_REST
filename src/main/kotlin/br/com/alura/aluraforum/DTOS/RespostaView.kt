package br.com.alura.aluraforum.DTOS

import br.com.alura.aluraforum.model.StatusTopico
import java.time.LocalDateTime

data class RespostaView(
    var id: Long?,
    var mensagem: String,
    var status: Boolean,
    var dataCriacao: LocalDateTime?
)