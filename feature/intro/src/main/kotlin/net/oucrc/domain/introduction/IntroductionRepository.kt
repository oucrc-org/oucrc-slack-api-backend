package net.oucrc.domain.introduction

import net.oucrc.ApiResult
import net.oucrc.domain.exception.DomainException

interface IntroductionRepository {
    suspend fun get(): ApiResult<Introduction?, DomainException>
    suspend fun upsert(introduction: Introduction): ApiResult<Unit, DomainException>
}
