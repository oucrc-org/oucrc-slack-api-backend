package net.oucrc.domain.user

import net.oucrc.ApiResult
import net.oucrc.domain.exception.DomainException

interface UserRepository {
    suspend fun getAll(): ApiResult<List<User>, DomainException>
    suspend fun getById(userId: UserId): ApiResult<User?, DomainException>
    suspend fun upsert(user: User): ApiResult<Unit, DomainException>
}
