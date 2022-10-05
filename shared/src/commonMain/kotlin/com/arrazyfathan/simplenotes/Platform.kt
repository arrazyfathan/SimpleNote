package com.arrazyfathan.simplenotes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform