package me.daehokimm.gaproxy.service

import me.daehokimm.gaproxy.dto.Payload
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(value = "ga-client", url = "https://www.google-analytics.com")
interface GoogleAnalyticsClient {

    @PostMapping("/collect")
    fun reportPageview(@RequestHeader("User-Agent") userAgent: String, @RequestBody payload: String)
}