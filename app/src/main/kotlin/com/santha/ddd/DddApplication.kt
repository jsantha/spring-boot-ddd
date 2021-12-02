package com.santha.ddd

import com.santha.shared.SharedKernel
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(SharedKernel::class)
class DddApplication

fun main(args: Array<String>) {
    runApplication<DddApplication>(*args)
}
