package br.com.alura.aluraforum.Service


import br.com.alura.aluraforum.DTOS.UsuarioForm
import br.com.alura.aluraforum.DTOS.UsuarioView
import br.com.alura.aluraforum.Mapper.UsuarioFormMapper
import br.com.alura.aluraforum.Mapper.UsuarioViewMapper
import br.com.alura.aluraforum.model.Usuario
import br.com.alura.aluraforum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UsuarioService (private val repository: UsuarioRepository,
                      private val usuarioFMapper: UsuarioFormMapper,
                      private val usuarioVMapper: UsuarioViewMapper,
                      private val notfoundmessage: String= "Topico não encontrado !"){

    fun buscaautoresId(id: Long): Usuario {
        return repository.getReferenceById(id)
    }
    fun listarautores(): List<UsuarioView> {
        return repository.findAll().stream().map {
                a ->usuarioVMapper.map(a)
        }.collect(Collectors.toList())

    }
    fun cadastrarautor(form: UsuarioForm) : UsuarioView {
        val usuario = usuarioFMapper.map(form)
        repository.save(usuario) // salva objeto curso na base de dados
        return usuarioVMapper.map(usuario)

    }
}