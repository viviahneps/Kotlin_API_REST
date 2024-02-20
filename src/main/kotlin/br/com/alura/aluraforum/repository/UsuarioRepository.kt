package br.com.alura.aluraforum.repository

import br.com.alura.aluraforum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}