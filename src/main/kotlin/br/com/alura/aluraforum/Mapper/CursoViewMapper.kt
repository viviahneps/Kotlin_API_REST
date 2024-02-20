package br.com.alura.aluraforum.Mapper

import br.com.alura.aluraforum.DTOS.CursoView
import br.com.alura.aluraforum.model.Curso
import org.springframework.stereotype.Component


@Component
class CursoViewMapper : Mapper<Curso, CursoView> {
    override fun map(c: Curso): CursoView {
        return CursoView(
            id = c.id,
            categoria = c.categoria,
            nome = c.nome
        )
    }
}