package br.com.alura.aluraforum.Mapper


import br.com.alura.aluraforum.DTOS.UsuarioForm
import br.com.alura.aluraforum.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioFormMapper : Mapper <UsuarioForm, Usuario> {
    override fun map(a: UsuarioForm): Usuario {
        return Usuario(
            id = a.id,
            nome = a.nome,
            email = a.email
        )
    }
}