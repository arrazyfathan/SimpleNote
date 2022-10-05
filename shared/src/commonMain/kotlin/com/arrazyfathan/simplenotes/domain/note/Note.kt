package com.arrazyfathan.simplenotes.domain.note

import com.arrazyfathan.simplenotes.presentation.*
import kotlinx.datetime.LocalDateTime

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */
data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val createdAt: LocalDateTime
) {
    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, LightGreenHex, BabyBlueHex, VioletHex)

        fun generateRandomColor() = colors.random()
    }
}