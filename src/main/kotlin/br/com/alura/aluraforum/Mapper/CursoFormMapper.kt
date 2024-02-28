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
    override fun map(t: CursoForm): Curso {
        return Curso(
            id = t.id,
            nome = t.nome,
            categoria = t.categoria
        )

    }
}