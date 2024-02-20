package br.com.alura.aluraforum.Mapper

import br.com.alura.aluraforum.DTOS.CursoForm
import br.com.alura.aluraforum.DTOS.TopicoForm
import br.com.alura.aluraforum.Service.CursoService
import br.com.alura.aluraforum.Service.UsuarioService
import br.com.alura.aluraforum.model.Curso
import br.com.alura.aluraforum.model.Topico
import org.springframework.stereotype.Component

@Component
class CursoFormMapper : Mapper<CursoForm, Curso> {
    override fun map(c: CursoForm): Curso {
        return Curso(
            id = c.id,
            nome = c.nome,
            categoria = c.categoria
        )

    }
}