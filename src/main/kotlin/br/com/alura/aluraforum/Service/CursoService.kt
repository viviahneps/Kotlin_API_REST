package br.com.alura.aluraforum.Service

import br.com.alura.aluraforum.DTOS.CursoForm
import br.com.alura.aluraforum.DTOS.CursoView
import br.com.alura.aluraforum.Mapper.CursoFormMapper
import br.com.alura.aluraforum.Mapper.CursoViewMapper
import br.com.alura.aluraforum.model.Curso
import br.com.alura.aluraforum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CursoService (private val repository: CursoRepository,
                    private val cursoVMapper: CursoViewMapper,
                    private val cursoFMapper: CursoFormMapper,
                    private val notfoundmessage: String= "Topico não encontrado !"){

    fun buscacursoId(id: Long):Curso {
        return repository.getReferenceById(id) // faz o select filtrandopela chave primaria direto
    }

    fun listarCurso(): List<CursoView> {
        return repository.findAll().stream().map {
                c -> cursoVMapper.map(c)
        }.collect(Collectors.toList())

    }
    fun cadastrarCurso(form: CursoForm) : CursoView {
        val curso = cursoFMapper.map(form)
        repository.save(curso) // salva objeto curso na base de dados
        return cursoVMapper.map(curso)

    }
}