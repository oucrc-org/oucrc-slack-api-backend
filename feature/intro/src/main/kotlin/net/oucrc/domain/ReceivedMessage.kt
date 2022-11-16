package net.oucrc.domain

data class ReceivedMessage(
    val user: User,
    val content: ReceivedContent,
)

@JvmInline
value class ReceivedContent(val value: String)
