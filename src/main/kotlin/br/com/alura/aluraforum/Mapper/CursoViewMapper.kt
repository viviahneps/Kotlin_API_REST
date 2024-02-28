package br.com.alura.aluraforum.Mapper

import br.com.alura.aluraforum.DTOS.CursoView
import br.com.alura.aluraforum.model.Curso
import org.springframework.stereotype.Component


@Component
class CursoViewMapper : Mapper<Curso, CursoView> {
    override fun map(t: Curso): CursoView {
        return CursoView(
            id = t.id,
            categoria = t.categoria,
            nome = t.nome
        )
    }
}