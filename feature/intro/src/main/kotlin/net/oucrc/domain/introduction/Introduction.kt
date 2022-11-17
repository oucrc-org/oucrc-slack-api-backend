package net.oucrc.domain.introduction

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import java.util.UUID

class Introduction private constructor(
    val id: IntroductionId,
    val content: IntroductionContent,
    val modifiedAt: Instant,
) {
    fun update(content: IntroductionContent) = Introduction(
        id = id,
        content = content,
        modifiedAt = Clock.System.now(),
    )

    companion object {
        fun create(content: IntroductionContent) = Introduction(
            id = IntroductionId(UUID.randomUUID().toString()),
            content = content,
            modifiedAt = Clock.System.now(),
        )
    }
}

@JvmInline
value class IntroductionId(val value: String)

@JvmInline
value class IntroductionContent(val value: String)
