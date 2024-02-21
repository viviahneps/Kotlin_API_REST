package br.com.alura.aluraforum.Mapper

import br.com.alura.aluraforum.DTOS.TopicoForm
import br.com.alura.aluraforum.Service.CursoService
import br.com.alura.aluraforum.Service.UsuarioService
import br.com.alura.aluraforum.model.Topico
import org.springframework.stereotype.Component

@Component
  class TopicoFormMapper(
    private var cursoservice: CursoService,
    private var autor: UsuarioService
       ) : Mapper<TopicoForm, Topico> {
       override fun map(t: TopicoForm): Topico {
            return Topico(
                id = t.id,
                titulo =t.titulo,
                mensagem = t.mensagem,
                curso = cursoservice.buscacursoId(t.idcurso),
                autor = autor.buscaautoresId(t.idautor)
            )


        }


}

