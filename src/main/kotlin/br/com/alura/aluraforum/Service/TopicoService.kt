package br.com.alura.aluraforum.Service

import br.com.alura.aluraforum.DTOS.TopicoAtlzForm
import br.com.alura.aluraforum.DTOS.TopicoForm
import br.com.alura.aluraforum.DTOS.TopicoView
import br.com.alura.aluraforum.Mapper.TopicoFormMapper
import br.com.alura.aluraforum.Mapper.TopicoViewMapper
import br.com.alura.aluraforum.exception.NotFoundException
import br.com.alura.aluraforum.model.Topico
import br.com.alura.aluraforum.repository.CursoRepository
import br.com.alura.aluraforum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService (private val repository: TopicoRepository,
                     private val topicoVMapper: TopicoViewMapper,
                     private val topicoFMapper: TopicoFormMapper,
                     private val notfoundmessage: String= "Topico não encontrado !"){

    fun listar(): List<TopicoView> {
     return repository.findAll().stream().map {
         t -> topicoVMapper.map(t)
         }.collect(Collectors.toList())

    }

    fun buscarporId(id: Long): TopicoView {
        val topico=repository.findById(id)
            .orElseThrow{NotFoundException(notfoundmessage)}
        return topicoVMapper.map(topico)


    }

    fun cadastrar(form: TopicoForm) : TopicoView {
        val topico = topicoFMapper.map(form)
        repository.save(topico) // salva objeto topico na base de dados
        return topicoVMapper.map(topico)

    }

    fun atualizar(form: TopicoAtlzForm) : TopicoView {
        val topico =repository.findById(form.id)
        .orElseThrow{NotFoundException(notfoundmessage)}

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return  topicoVMapper.map(topico)
    }

    fun deletar(id : Long) {
        val topico= repository.deleteById(id)
    }


}
