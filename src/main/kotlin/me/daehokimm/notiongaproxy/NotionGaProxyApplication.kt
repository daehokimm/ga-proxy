package me.daehokimm.notiongaproxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class NotionGaProxyApplication

fun main(args: Array<String>) {
	runApplication<NotionGaProxyApplication>(*args)
}
