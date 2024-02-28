package br.com.alura.aluraforum.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor
data class Curso(
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    var id: Long? ,
    val nome: String,
    val categoria: String
        ) {
    constructor(): this(0, "","")
}



