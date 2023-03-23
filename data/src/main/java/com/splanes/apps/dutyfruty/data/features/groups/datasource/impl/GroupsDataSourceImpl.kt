package com.splanes.apps.dutyfruty.data.features.groups.datasource.impl

import com.google.firebase.database.FirebaseDatabase
import com.splanes.apps.dutyfruty.data.common.utils.firebase.await
import com.splanes.apps.dutyfruty.data.features.groups.datasource.GroupsDataSource
import com.splanes.apps.dutyfruty.data.features.groups.entity.GroupMemberEntity
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class GroupsDataSourceImpl @Inject constructor(
    private val database: FirebaseDatabase
) : GroupsDataSource {

    override suspend fun saveGroupMember(member: GroupMemberEntity) {
        database
            .getReference(MembersPath)
            .push()
            .setValue(member)
            .await()
    }

    override suspend fun getAllMembers(): List<GroupMemberEntity> =
        database
            .getReference(MembersPath)
            .await { snapshot ->
                snapshot.children.map { child -> child.getValue(GroupMemberEntity::class.java) }
            }
            .orEmpty()
            .filterNotNull()
}

private const val MembersPath = "public/members"