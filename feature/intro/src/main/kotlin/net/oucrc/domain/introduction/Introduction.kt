package net.oucrc.domain.introduction

import kotlinx.datetime.Instant

class Introduction(
    val id: IntroductionId,
    val content: IntroductionContent,
    val modifiedAt: Instant,
)

@JvmInline
value class IntroductionId(val value: String)

@JvmInline
value class IntroductionContent(val value: String)
