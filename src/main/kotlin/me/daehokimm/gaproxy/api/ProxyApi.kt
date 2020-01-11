package me.daehokimm.gaproxy.api

import me.daehokimm.gaproxy.dto.HitInfo
import me.daehokimm.gaproxy.service.ProxyService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProxyApi(
        private val proxyService: ProxyService
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/hits")
    fun collectHits(
            @RequestHeader("User-Agent") userAgent: String,
            @RequestHeader("Host") host: String,
            @RequestParam("page") targetPage: String
    ): ResponseEntity<Any> {
        logger.info("$targetPage is hit!")
        proxyService.reportHitToGA(HitInfo(userAgent, host, targetPage))
        return ResponseEntity.ok().build()
    }
}