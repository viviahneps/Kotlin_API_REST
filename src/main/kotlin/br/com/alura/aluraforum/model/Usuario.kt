package br.com.alura.aluraforum.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Usuario (
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
val id: Long?,
val nome: String,
val email: String
        ){
    private constructor(): this(0, "","")
}
