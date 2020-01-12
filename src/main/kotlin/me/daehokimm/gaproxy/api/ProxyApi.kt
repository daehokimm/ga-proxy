package me.daehokimm.gaproxy.api

import me.daehokimm.gaproxy.dto.HitInfo
import me.daehokimm.gaproxy.service.ProxyService
import org.apache.commons.io.IOUtils
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.io.InputStream

@Controller
class ProxyApi(
        private val proxyService: ProxyService
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @ResponseBody
    @GetMapping(
            value = ["/hits"],
            produces = [MediaType.IMAGE_PNG_VALUE]
    )
    fun collectHits(
            @RequestHeader("User-Agent") userAgent: String,
            @RequestHeader("Host") host: String,
            @RequestParam("page") targetPage: String
    ): ByteArray? {
        logger.info("$targetPage is hit!")
        proxyService.reportHitToGA(HitInfo(userAgent, host, targetPage))
        val `in`: InputStream = javaClass.getResourceAsStream("/images/ok.png")
        return IOUtils.toByteArray(`in`)
    }
}