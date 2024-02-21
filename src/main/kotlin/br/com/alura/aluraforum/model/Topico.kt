package br.com.alura.aluraforum.model

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*
@Entity

data class   Topico(
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    var id: Long?,
    var titulo: String,
    var mensagem: String,
    val dataCriacao: LocalDateTime? = LocalDateTime.now(),
    @ManyToOne  //indica relacionamento de 1:M
    val curso: Curso?,
    @ManyToOne
    val autor: Usuario?,
    @Enumerated(value = EnumType.STRING) // para que nao seja gravado a ordem da constante na coluna da tabela
    val status: StatusTopico= StatusTopico.NAO_RESPONDIDO,
    @OneToMany(mappedBy = "topico")
    val respostas: List<Resposta> =  ArrayList ()
){
constructor() : this(null," ", "", null,null,null)
}
