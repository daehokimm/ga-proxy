package me.daehokimm.notiongaproxy.dto

data class Payload(
        var tid: String,
        var cid: String,
        var dp: String,
        val v: String = "1",
        val t: String = "pageview"      // support only pageview now. ;_;
)