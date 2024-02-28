package br.com.alura.aluraforum.Mapper

import br.com.alura.aluraforum.DTOS.RespostaView
import br.com.alura.aluraforum.DTOS.TopicoView
import br.com.alura.aluraforum.Service.TopicoService
import br.com.alura.aluraforum.model.Resposta
import org.springframework.stereotype.Component

@Component
class RespostaViewMapper : Mapper<Resposta, RespostaView> {
    override fun map(r: Resposta): RespostaView {
        return RespostaView(
             id=r.id,
             mensagem=r.mensagem,
             status=r.status,
             dataCriacao=r.dataCriacao
        )


    }

}
