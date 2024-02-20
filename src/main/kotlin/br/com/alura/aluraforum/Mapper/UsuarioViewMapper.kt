package br.com.alura.aluraforum.Mapper

import br.com.alura.aluraforum.DTOS.CursoView
import br.com.alura.aluraforum.DTOS.UsuarioView
import br.com.alura.aluraforum.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioViewMapper : Mapper<Usuario, UsuarioView> {
    override fun map(a: Usuario): UsuarioView {
        return UsuarioView(
            id = a.id,
            nome = a.nome,
            email = a.email
        )
    }
}