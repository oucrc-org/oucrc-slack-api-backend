package net.oucrc.domain

import net.oucrc.domain.user.User

data class ReceivedMessage(
    val user: User,
    val content: ReceivedContent,
)

@JvmInline
value class ReceivedContent(val value: String)
