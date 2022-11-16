package net.oucrc.usecase.introduction

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.oucrc.ApiResult
import net.oucrc.domain.exception.DomainException
import net.oucrc.domain.introduction.Introduction
import net.oucrc.domain.introduction.IntroductionContent
import net.oucrc.domain.introduction.IntroductionRepository
import net.oucrc.flatMap
import net.oucrc.map

class UpsertIntroductionUseCase(
    private val introductionRepository: IntroductionRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) {
    suspend operator fun invoke(content: IntroductionContent): ApiResult<Unit, DomainException> =
        withContext(dispatcher) {
            introductionRepository
                .get()
                .map { it?.update(content) ?: Introduction.create(content) }
                .flatMap { introduction -> introductionRepository.upsert(introduction) }
        }
}
