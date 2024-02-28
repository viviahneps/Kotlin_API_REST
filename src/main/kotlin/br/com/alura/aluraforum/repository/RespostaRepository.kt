package br.com.alura.aluraforum.repository

import br.com.alura.aluraforum.model.Resposta
import org.springframework.data.jpa.repository.JpaRepository

interface RespostaRepository : JpaRepository<Resposta, Long> {

}
