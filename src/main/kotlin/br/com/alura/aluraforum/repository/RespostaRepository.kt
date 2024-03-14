package br.com.alura.aluraforum.repository

import br.com.alura.aluraforum.model.Resposta
import br.com.alura.aluraforum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface RespostaRepository : JpaRepository<Resposta,Long> {
    fun findByTopicoRespostas(id: Long, paginacao: Pageable): Page<Resposta>
}
