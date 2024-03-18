package br.com.alura.aluraforum.model

import br.com.alura.aluraforum.DTOS.TopicoView
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity


data class Resposta(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var mensagem: String,
    val dataCriacao: LocalDateTime? = LocalDateTime.now(),
    @ManyToOne
    val autor: Usuario?,
    @ManyToOne
    val topico: Topico?,
    var status: Boolean



){
    constructor() : this(0," ", null, null,null,false)
}