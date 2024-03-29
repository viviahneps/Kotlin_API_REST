package br.com.alura.aluraforum.controller

import br.com.alura.aluraforum.DTOS.TopicoAtlzForm
import br.com.alura.aluraforum.DTOS.TopicoForm
import br.com.alura.aluraforum.DTOS.TopicoView
import br.com.alura.aluraforum.Service.TopicoService
import io.swagger.v3.oas.annotations.Operation
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping ("/topicos")
class TopicoController(private val service: TopicoService) {

   @Operation(summary = "Lista tópicos cadastrados")
   @GetMapping
   fun listar(
       @RequestParam(required = false ) nomeCurso : String?,
       @PageableDefault(size= 5, sort = ["dataCriacao"], direction = Sort.Direction.DESC) paginacao: Pageable // para restringir a 5dados por pagina e também por ordem desc por data
    ): Page<TopicoView> {
       return service.listar(nomeCurso,paginacao)
    }



    @Operation(summary = "Lista tópicos cadastrados por ID")
    @GetMapping ("/{id}")
    //Path indica que o parametro vem no endpoint
    fun buscaId(@PathVariable id: Long): TopicoView{
    return service.buscarporId(id)
    }

    @Operation(summary = "Cadastra tópico")
    @PostMapping
    @Transactional
    //RequestBody indica que o parametro vem pelo corpo da mensagem
    fun cadastrar(@RequestBody @Valid dto:TopicoForm,
                  uriBuilder: UriComponentsBuilder
        ) : ResponseEntity<TopicoView>{
        val topicoView = service.cadastrar(dto)
        val uri =uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @Operation(summary = "Atualiza tópico")
    @PutMapping
    @Transactional
    fun atualilzar(@RequestBody @Valid form: TopicoAtlzForm) : ResponseEntity<TopicoView>{
     val topicoView = service.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }

    @Operation(summary = "Exclui tópico")
    @DeleteMapping ("/{id}")
    @Transactional //indica que será efetuado uma transação no banco apenas para metodos de escrita na base
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable  id: Long){
        service.deletar(id)
    }
}
