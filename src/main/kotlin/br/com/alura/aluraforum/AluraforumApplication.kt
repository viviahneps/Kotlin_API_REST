package br.com.alura.aluraforum

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching


@SpringBootApplication
@EnableCaching
class AluraforumApplication

fun main(args: Array<String>) {
	SpringApplication.run(AluraforumApplication::class.java,*args)
}
