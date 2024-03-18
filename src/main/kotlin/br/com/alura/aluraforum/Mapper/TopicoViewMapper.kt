package br.com.alura.aluraforum.Mapper

import br.com.alura.aluraforum.DTOS.TopicoView
import br.com.alura.aluraforum.model.*
import jakarta.persistence.*
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, TopicoView> {
    override fun map(t: Topico): TopicoView {
       return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
            )


    }


}