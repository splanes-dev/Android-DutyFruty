package com.splanes.apps.dutyfruty.domain.features.groups.usecase

import com.splanes.apps.dutyfruty.domain.common.UseCase
import com.splanes.apps.dutyfruty.domain.features.groups.model.Group
import com.splanes.apps.dutyfruty.domain.features.groups.repository.GroupsRepository
import com.splanes.apps.dutyfruty.domain.features.groups.request.CreateGroupRequest
import javax.inject.Inject

class CreateGroupUseCase @Inject constructor(
    private val repository: GroupsRepository
) : UseCase<CreateGroupRequest, Group>() {

    override suspend fun execute(params: CreateGroupRequest): Group =
        repository.saveGroup(params)
}