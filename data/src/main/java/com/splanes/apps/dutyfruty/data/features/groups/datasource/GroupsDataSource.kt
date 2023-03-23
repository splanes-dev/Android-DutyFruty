package com.splanes.apps.dutyfruty.data.features.groups.datasource

import com.splanes.apps.dutyfruty.data.features.groups.entity.GroupMemberEntity

interface GroupsDataSource {

    suspend fun saveGroupMember(member: GroupMemberEntity)

    suspend fun getAllMembers(): List<GroupMemberEntity>
}