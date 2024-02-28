package br.com.alura.aluraforum.Service

import br.com.alura.aluraforum.DTOS.*
import br.com.alura.aluraforum.Mapper.RespostaFormMapper
import br.com.alura.aluraforum.Mapper.RespostaViewMapper
import br.com.alura.aluraforum.Mapper.TopicoFormMapper
import br.com.alura.aluraforum.Mapper.TopicoViewMapper
import br.com.alura.aluraforum.exception.NotFoundException
import br.com.alura.aluraforum.model.Resposta
import br.com.alura.aluraforum.model.Topico
import br.com.alura.aluraforum.repository.RespostaRepository
import br.com.alura.aluraforum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RespostaService (
    private var respostas : List<Resposta> = ArrayList(),
    private val topicorepopsitory: TopicoRepository,
    private val topicoVMapper: TopicoViewMapper,
    private val topicoFMapper: TopicoFormMapper,
    private val repository: RespostaRepository,
    private val respostaVMapper: RespostaViewMapper,
    private val respostaFMapper: RespostaFormMapper,
    private val notfoundmessage: String= "Topico não encontrado !"){

        fun listaResposta(): List<RespostaView> {
            return repository.findAll().stream().map {
                       t -> respostaVMapper.map(t)
                }.collect(Collectors.toList())
            }

        fun cadastrarResposta(form: RespostaForm) : RespostaView {
          val resposta = respostaFMapper.map(form)
           repository.save(resposta) // salva objeto topico na base de dados
           return respostaVMapper.map(resposta)
           }


      fun buscarporRespId(id: Long): RespostaView {
        val resposta=repository.findById(id)
            .orElseThrow{ NotFoundException(notfoundmessage) }
        return respostaVMapper.map(resposta)
       }




}