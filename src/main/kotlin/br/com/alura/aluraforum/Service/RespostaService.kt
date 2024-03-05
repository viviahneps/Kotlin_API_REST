package br.com.alura.aluraforum.Service

import br.com.alura.aluraforum.DTOS.*
import br.com.alura.aluraforum.Mapper.RespostaFormMapper
import br.com.alura.aluraforum.Mapper.RespostaViewMapper
import br.com.alura.aluraforum.Mapper.TopicoFormMapper
import br.com.alura.aluraforum.Mapper.TopicoViewMapper
import br.com.alura.aluraforum.exception.NotFoundException
import br.com.alura.aluraforum.model.Resposta
import br.com.alura.aluraforum.model.StatusTopico
import br.com.alura.aluraforum.repository.RespostaRepository
import br.com.alura.aluraforum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class RespostaService (

    private var topicoservice: TopicoService,
    private val topicorepopsitory: TopicoRepository,
    private var respostas :MutableList <Resposta> = mutableListOf(),
    private val topicoVMapper: TopicoViewMapper,
    private val topicoFMapper: TopicoFormMapper,
    private val repository: RespostaRepository,
    private val respostaVMapper: RespostaViewMapper,
    private val respostaFMapper: RespostaFormMapper,
    private val notfoundmessage: String= "Topico não encontrado !"){


    fun listaResposta(paginacao: Pageable): Page<RespostaView> {
       val respostas= repository.findAll(paginacao)
        return respostas.map {
                t -> respostaVMapper.map(t)
        }
    }

        fun cadastrarResposta(form: RespostaForm) : RespostaView {
            val resposta = respostaFMapper.map(form)
                respostas.add(resposta)
                repository.save(resposta)

            val topico =topicorepopsitory.findById(form.topico)
                .orElseThrow{NotFoundException(notfoundmessage)}

               if(form.status.equals(true)){
                  topico.status= StatusTopico.SOLUCIONADO
                }
               else{
                 topico.status= StatusTopico.NAO_SOLUCIONADO
                }

            topico.respostas?.plus(respostas.get(form.id.toInt()))
            topicorepopsitory.save(topico)
            return  respostaVMapper.map(resposta)
        }


        fun buscarporRespId(id: Long): RespostaView {
          val resposta=repository.findById(id)
            .orElseThrow{ NotFoundException(notfoundmessage) }
          return respostaVMapper.map(resposta)
        }

    fun atribuiresposta(form: RespostaForm):TopicoView{
        val topico =topicorepopsitory.findById(form.topico)
            .orElseThrow{NotFoundException(notfoundmessage)}

      //  topico.respostas.add(respostaFMapper.map(form))
        topicorepopsitory.save(topico)
        return topicoVMapper.map(topico)
    }


}