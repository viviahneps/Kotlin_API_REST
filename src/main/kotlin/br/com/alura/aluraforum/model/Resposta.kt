package br.com.alura.aluraforum.model

import java.time.LocalDateTime

data class Resposta (
    val id:Long? = null,
    val mensagem: String,
    val datacriacao: LocalDateTime = LocalDateTime.now(),
    val autor:Usuario,
    val topico: Topico,
    val solucao: Boolean

        )