package me.daehokimm.gaproxy.dto

data class HitInfo(
        val userAgent: String,
        val userHost: String,
        val targetPage: String
)