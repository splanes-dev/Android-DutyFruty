package com.splanes.apps.dutyfruty.domain.features.groups.repository

import com.splanes.apps.dutyfruty.domain.features.groups.model.Group
import com.splanes.apps.dutyfruty.domain.features.groups.model.GroupMember

interface GroupsRepository {

    suspend fun saveGroupMember(member: GroupMember)

    suspend fun getMembers(emails: List<String>): List<GroupMember>

    suspend fun getCurrentGroupMember(): GroupMember

    suspend fun saveGroup(group: Group)

    suspend fun editGroup(group: Group)

    suspend fun removeGroup(group: Group)
}
