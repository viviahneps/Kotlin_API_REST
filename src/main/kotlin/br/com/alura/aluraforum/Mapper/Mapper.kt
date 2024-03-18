package br.com.alura.aluraforum.Mapper

import br.com.alura.aluraforum.model.Topico
import br.com.alura.aluraforum.model.Usuario
import java.time.chrono.ChronoLocalDate
import java.time.chrono.ChronoLocalDateTime
import java.util.*


interface Mapper<T, U> {
    fun map(t: T): U
}