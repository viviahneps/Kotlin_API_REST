package br.com.alura.aluraforum.Mapper

import br.com.alura.aluraforum.DTOS.TopicoView
import br.com.alura.aluraforum.Service.CursoService
import br.com.alura.aluraforum.Service.UsuarioService
import br.com.alura.aluraforum.model.*
import jakarta.persistence.*
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.ArrayList

@Component
class TopicoViewMapper : Mapper<Topico, TopicoView> {
    override fun map(t: Topico): TopicoView {
       return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status,
            )


    }


}