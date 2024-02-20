package br.com.alura.aluraforum.repository

import br.com.alura.aluraforum.model.Curso
import br.com.alura.aluraforum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
}