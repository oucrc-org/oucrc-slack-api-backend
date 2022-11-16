package net.oucrc.usecase.introduction

import kotlinx.datetime.Instant
import net.oucrc.domain.introduction.Introduction
import net.oucrc.domain.introduction.IntroductionContent
import net.oucrc.domain.introduction.IntroductionId

data class IntroductionUseCaseModel(
    val id: IntroductionId,
    val content: IntroductionContent,
    val modifiedAt: Instant,
) {
    companion object {
        fun from(introduction: Introduction) = IntroductionUseCaseModel(
            id = introduction.id,
            content = introduction.content,
            modifiedAt = introduction.modifiedAt,
        )
    }
}
