package me.daehokimm.notiongaproxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NotionGaProxyApplication

fun main(args: Array<String>) {
	runApplication<NotionGaProxyApplication>(*args)
}
