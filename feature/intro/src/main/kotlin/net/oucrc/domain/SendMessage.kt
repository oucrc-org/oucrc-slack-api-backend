package net.oucrc.domain

data class SendMessage(
    val content: SendContent,
)

@JvmInline
value class SendContent(val value: String)
