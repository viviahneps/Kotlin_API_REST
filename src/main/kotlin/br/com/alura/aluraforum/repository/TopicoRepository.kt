package br.com.alura.aluraforum.repository

import br.com.alura.aluraforum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico,Long>{
}