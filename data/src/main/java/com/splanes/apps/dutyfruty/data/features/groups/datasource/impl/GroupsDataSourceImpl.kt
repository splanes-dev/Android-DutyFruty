package com.splanes.apps.dutyfruty.data.features.groups.datasource.impl

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.splanes.apps.dutyfruty.data.common.utils.firebase.await
import com.splanes.apps.dutyfruty.data.common.utils.sha.md5
import com.splanes.apps.dutyfruty.data.features.groups.datasource.GroupsDataSource
import com.splanes.apps.dutyfruty.data.features.groups.entity.GroupEntity
import com.splanes.apps.dutyfruty.data.features.groups.entity.GroupMemberEntity
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class GroupsDataSourceImpl @Inject constructor(
    private val auth: FirebaseAuth,
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

    override suspend fun saveGroup(group: GroupEntity) {
        val uid = auth.currentUser?.uid.orEmpty()
        database
            .getReference("$uid/$GroupsPath")
            .push()
            .setValue(group)
            .await()

        group.members?.filter { e -> e != group.owner }?.forEach { member ->
            database
                .getReference(QueueGroupsPath)
                .child(member.md5())
                .setValue(group)
                .await()
        }
    }

    override suspend fun getCurrentGroupMember(): GroupMemberEntity =
        GroupMemberEntity(
            id = auth.currentUser?.uid,
            username = auth.currentUser?.displayName,
            email = auth.currentUser?.email,
        )
}

private const val MembersPath = "public/members"
private const val QueueGroupsPath = "public/queue/groups"
private const val GroupsPath = "groups"
