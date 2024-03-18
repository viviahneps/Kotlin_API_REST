package br.com.alura.aluraforum.repository

import br.com.alura.aluraforum.model.Resposta
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface RespostaRepository : JpaRepository<Resposta,Long> {
  // fun findByTopicoRespostas(id: Long, paginacao: Pageable): Page<Resposta>

    @Query(value = "SELECT * FROM RESPOSTA WHERE topico_id= :id", nativeQuery=true)
    fun buscarespostatopico(@Param("id")id: Long, paginacao: Pageable): Page<Resposta>


}
