package br.com.alura.aluraforum.Mapper

import br.com.alura.aluraforum.DTOS.RespostaForm
import br.com.alura.aluraforum.Service.TopicoService
import br.com.alura.aluraforum.Service.UsuarioService
import br.com.alura.aluraforum.model.Resposta
import br.com.alura.aluraforum.repository.TopicoRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime


@Component
  class RespostaFormMapper (
     private var autor: UsuarioService,
     private var topico: TopicoService
     ) : Mapper< RespostaForm, Resposta> {
    override fun map(t: RespostaForm): Resposta {

     //  val retorno = topico.buscaIdEspecial(t.id)
        return Resposta(
            id = t.id,
            mensagem =t.mensagem,
            autor =autor.buscaautoresId(t.idautor),
            topico =topico.buscaIdEspecial(t.topico),
            status = t.status
        )
    }
}




