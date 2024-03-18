package br.com.alura.aluraforum.Service

import br.com.alura.aluraforum.DTOS.*
import br.com.alura.aluraforum.Mapper.RespostaFormMapper
import br.com.alura.aluraforum.Mapper.RespostaViewMapper
import br.com.alura.aluraforum.exception.NotFoundException
import br.com.alura.aluraforum.model.Resposta
import br.com.alura.aluraforum.model.StatusTopico
import br.com.alura.aluraforum.repository.RespostaRepository
import br.com.alura.aluraforum.repository.TopicoRepository
import jakarta.persistence.NamedQuery
import jakarta.persistence.Table
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList


@Service
class RespostaService (private var topicoservice: TopicoService,
                       private val topicorepository: TopicoRepository,
                       private var respostas :MutableList <Resposta> = ArrayList(),
                       private val repository: RespostaRepository,
                       private val respostaVMapper: RespostaViewMapper,
                       private val respostaFMapper: RespostaFormMapper,
                       private val notfoundmessage: String= "Topico não encontrado !"){

    fun listarResposta(
        idtopico: Long?,
        paginacao: Pageable
      ): Page<RespostaView>{



        val respostas: Page<Resposta> = if(idtopico == null){
           repository.findAll(paginacao)
        } else {
            repository.buscarespostatopico(idtopico, paginacao)

        }
        return respostas.map {
                t -> respostaVMapper.map(t)
        }
    }

      fun buscarRespostaporId(id: Long): RespostaView {
        val resposta= repository.findById(id)
            .orElseThrow{NotFoundException(notfoundmessage)}
        return respostaVMapper.map(resposta)
      }

       fun cadastrarResposta(form: RespostaForm) : RespostaView {
           val topico = topicorepository.findById(form.topico)
               .orElseThrow{NotFoundException(notfoundmessage)}

           if(topico.status.equals(StatusTopico.FECHADO)) {
               throw Exception("TÓPICO com status FECHADO - Não é possivel efetuar novos cadastro de resposta!")
           }

               val resposta = respostaFMapper.map(form)
               respostas.add(resposta)
               repository.save(resposta)


               if (form.status.equals(true)) {

                   topico.status = StatusTopico.SOLUCIONADO
               } else {
                   topico.status = StatusTopico.NAO_SOLUCIONADO
               }

               return respostaVMapper.map(resposta)

       }

       fun buscarporRespId(id: Long): RespostaView {
          val resposta=repository.findById(id)
            .orElseThrow{ NotFoundException(notfoundmessage) }
          return respostaVMapper.map(resposta)
       }


    fun atualizarResposta(form: RespostaAtlzForm) : RespostaView {
        val topico =topicorepository.findById(form.topico)
            .orElseThrow{NotFoundException(notfoundmessage)}

        if(topico.status.equals(StatusTopico.NAO_RESPONDIDO)) {
            throw Exception("Tópico sem resposta cadastrada")
        }

        val resposta =repository.findById(form.id)
            .orElseThrow{NotFoundException(notfoundmessage)}

        val status= atualizaStatus(form.status,form.topico)

            resposta.mensagem = form.mensagem
            resposta.status = form.status
            topico.status = status
            topicorepository.save(topico)
            return  respostaVMapper.map(resposta)
        }


    fun atualizaStatus(status: Boolean,id: Long) : StatusTopico {

        val topico = topicorepository.findById(id)
            .orElseThrow{NotFoundException(notfoundmessage)}


        if(topico.status.equals(StatusTopico.NAO_RESPONDIDO) && status.equals(true)){
            return StatusTopico.SOLUCIONADO
        }
        if(topico.status.equals(StatusTopico.NAO_SOLUCIONADO) && status.equals(true)){
            return StatusTopico.SOLUCIONADO
        }
        if(topico.status.equals(StatusTopico.SOLUCIONADO) && status.equals(true)){
            return StatusTopico.FECHADO
        }
        if(topico.status.equals(StatusTopico.NAO_RESPONDIDO) && status.equals(false)){
            return StatusTopico.NAO_SOLUCIONADO
        }
        if(topico.status.equals(StatusTopico.SOLUCIONADO) && status.equals(false)){
            return StatusTopico.SOLUCIONADO
        }
        if(topico.status.equals(StatusTopico.NAO_SOLUCIONADO) && status.equals(false)){
            return StatusTopico.NAO_SOLUCIONADO
        }
        if(topico.status.equals(StatusTopico.FECHADO) && status.equals(false)){
            return StatusTopico.FECHADO
        }
        else {
            throw Exception("TÓPICO com status FECHADO - Não é possivel efetuar alteração!")
                return StatusTopico.FECHADO
            }
    }


    }










