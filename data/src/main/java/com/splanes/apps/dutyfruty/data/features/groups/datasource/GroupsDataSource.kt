package com.splanes.apps.dutyfruty.data.features.groups.datasource

import com.splanes.apps.dutyfruty.data.features.groups.entity.GroupEntity
import com.splanes.apps.dutyfruty.data.features.groups.entity.GroupMemberEntity

interface GroupsDataSource {

	suspend fun saveGroupMember(member: GroupMemberEntity)

	suspend fun getAllMembers(): List<GroupMemberEntity>

	suspend fun saveGroup(group: GroupEntity)

	suspend fun getCurrentGroupMember(): GroupMemberEntity
}
