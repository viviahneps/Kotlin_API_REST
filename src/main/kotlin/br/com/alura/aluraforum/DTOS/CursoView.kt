package br.com.alura.aluraforum.DTOS

import br.com.alura.aluraforum.model.StatusTopico
import java.time.LocalDateTime

data class CursoView(
    var id : Long?,
    var nome : String,
    var categoria: String

)