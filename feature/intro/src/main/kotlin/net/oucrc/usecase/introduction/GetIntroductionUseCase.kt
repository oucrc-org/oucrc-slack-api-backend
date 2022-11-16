package net.oucrc.usecase.introduction

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.oucrc.ApiResult
import net.oucrc.domain.exception.DomainException
import net.oucrc.domain.introduction.IntroductionRepository
import net.oucrc.map

class GetIntroductionUseCase(
    private val introductionRepository: IntroductionRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) {
    suspend operator fun invoke(): ApiResult<IntroductionUseCaseModel, DomainException> =
        withContext(dispatcher) {
            introductionRepository
                .get()
                .map { IntroductionUseCaseModel.from(it) }
        }
}
