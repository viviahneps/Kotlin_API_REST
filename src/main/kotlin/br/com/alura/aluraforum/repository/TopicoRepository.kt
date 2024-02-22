package br.com.alura.aluraforum.repository

import br.com.alura.aluraforum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository


interface TopicoRepository : JpaRepository<Topico,Long>{
    // findBy indica ao jpa data que ele precisará fazer um select
    //acrescer do nome do Objeto e do nome do campo extamente neste padrão
   fun findByCursoNome(nomeCurso: String, paginacao: Pageable) : Page<Topico>


}