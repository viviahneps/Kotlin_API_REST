package br.com.alura.aluraforum.model

import java.time.LocalDateTime
import java.util.*

data class Topico(
 var id: Long? = null,
 var titulo: String,
 val mensagem: String,
 val dataCriacao:LocalDateTime = LocalDateTime.now(),
 val curso: Curso,
 val autor: Usuario,
 val status: StatusTopico= StatusTopico.NAO_RESPONDIDO,
val respostas: List<Resposta> =  ArrayList ()
)
