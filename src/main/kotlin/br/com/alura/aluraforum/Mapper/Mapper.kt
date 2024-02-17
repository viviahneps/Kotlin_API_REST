package br.com.alura.aluraforum.Mapper

interface Mapper<T, U> {
 fun map(t:T): U

}
