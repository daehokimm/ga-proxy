package me.daehokimm.gaproxy.service

import me.daehokimm.gaproxy.dto.HitInfo
import me.daehokimm.gaproxy.dto.Payload
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ProxyService (
        val gaClient: GoogleAnalyticsClient
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Value("\${google-analytics.tracking-id}")
    private lateinit var trackingId: String

    fun reportHitToGA(hitInfo: HitInfo) {
        val payload = parsedQueryString(hitInfo)
        logger.debug("payload : $payload")

        gaClient.reportPageview(hitInfo.userAgent, payload)     // always return 2xx
    }

    private fun parsedQueryString(hitInfo: HitInfo): String {
        return ""
                .plus("v=1&")
                .plus("tid=$trackingId&")
                .plus("cid=${hitInfo.userHost}&")
                .plus("t=pageview&")
                .plus("dp=%2F${hitInfo.targetPage}")
    }
}