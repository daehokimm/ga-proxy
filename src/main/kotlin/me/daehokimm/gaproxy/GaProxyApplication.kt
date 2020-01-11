package me.daehokimm.gaproxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class GaProxyApplication

fun main(args: Array<String>) {
	runApplication<GaProxyApplication>(*args)
}
