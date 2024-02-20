package br.com.alura.aluraforum.controller
import br.com.alura.aluraforum.DTOS.UsuarioForm
import br.com.alura.aluraforum.DTOS.UsuarioView
import br.com.alura.aluraforum.Service.UsuarioService
import io.swagger.v3.oas.annotations.Operation
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/autores")
class UsuarioController  (private val service: UsuarioService) {

    @Operation(summary = "Obtem lista de autores no tópico")
    @GetMapping
    fun listarCurso(): List<UsuarioView> {
        return service.listarautores()
    }

    @Operation(summary = "Efetua cadastro de Autor no tópico")
    @PostMapping
    @Transactional

    fun cadastrarUsuario(
        @RequestBody @Valid cdto: UsuarioForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<UsuarioView> {
        val usuarioView = service.cadastrarautor(cdto)
        val uri = uriBuilder.path("/autores/${usuarioView.id}").build().toUri()
        return ResponseEntity.created(uri).body(usuarioView)
    }
}