package br.com.alura.aluraforum.Service

import br.com.alura.aluraforum.DTOS.TopicoForm
import br.com.alura.aluraforum.DTOS.TopicoView
import br.com.alura.aluraforum.Mapper.TopicoFormMapper
import br.com.alura.aluraforum.Mapper.TopicoViewMapper
import br.com.alura.aluraforum.model.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService (private var topicos: List<Topico> = ArrayList(),
                     private val topicoVMapper: TopicoViewMapper,
                     private val topicoFMapper: TopicoFormMapper){

    fun listar(): List<TopicoView> {
     return topicos.stream().map {
         t -> topicoVMapper.map(t)
         }.collect(Collectors.toList())

    }

    fun buscarporId(id: Long): TopicoView {
        val topico= topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topicoVMapper.map(topico)


    }

    fun cadastrar(form: TopicoForm) {
        val topico = topicoFMapper.map(form)
         topico.id = topicos.size.toLong()+1
        topicos= topicos.plus(topico)

    }


}
