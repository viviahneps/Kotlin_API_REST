package br.com.alura.aluraforum.Mapper

import br.com.alura.aluraforum.DTOS.RespostaView
import br.com.alura.aluraforum.model.Resposta
import org.springframework.stereotype.Component

@Component
class RespostaViewMapper : Mapper<Resposta, RespostaView> {
    override fun map(t: Resposta): RespostaView {
        return RespostaView(
             id=t.id,
             mensagem=t.mensagem,
             status=t.status,
             dataCriacao=t.dataCriacao
        )


    }

}
