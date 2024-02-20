package br.com.alura.aluraforum.DTOS

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotEmpty

class UsuarioForm (

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    var id: Long,
    @field: NotEmpty
    val nome: String,
    @field: NotEmpty
    val email: String

)
