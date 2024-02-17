package br.com.alura.aluraforum.Service

import br.com.alura.aluraforum.DTOS.TopicoAtlzForm
import br.com.alura.aluraforum.DTOS.TopicoForm
import br.com.alura.aluraforum.DTOS.TopicoView
import br.com.alura.aluraforum.Mapper.TopicoFormMapper
import br.com.alura.aluraforum.Mapper.TopicoViewMapper
import br.com.alura.aluraforum.exception.NotFoundException
import br.com.alura.aluraforum.model.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService (private var topicos: List<Topico> = ArrayList(),
                     private val topicoVMapper: TopicoViewMapper,
                     private val topicoFMapper: TopicoFormMapper,
                    private val notfoundmessage: String= "Topico não encontrado !"){

    fun listar(): List<TopicoView> {
     return topicos.stream().map {
         t -> topicoVMapper.map(t)
         }.collect(Collectors.toList())

    }

    fun buscarporId(id: Long): TopicoView {
        val topico= topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notfoundmessage)}
        return topicoVMapper.map(topico)


    }

    fun cadastrar(form: TopicoForm) : TopicoView {
        val topico = topicoFMapper.map(form)
         topico.id = topicos.size.toLong()+1
        topicos= topicos.plus(topico)
        return topicoVMapper.map(topico)

    }

    fun atualizar(form: TopicoAtlzForm) : TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().orElseThrow{NotFoundException(notfoundmessage)}
        val topicoNew = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            dataCriacao = topico.dataCriacao)
        topicos = topicos.minus(topico).plus(topicoNew)

        return  topicoVMapper.map(topicoNew)
    }

    fun deletar(id : Long) {
        val topico= topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notfoundmessage)}
        topicos= topicos.minus(topico)
    }


}
