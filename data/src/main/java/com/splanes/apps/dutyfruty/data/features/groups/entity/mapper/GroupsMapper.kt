package com.splanes.apps.dutyfruty.data.features.groups.entity.mapper

import com.splanes.apps.dutyfruty.data.features.groups.entity.GroupEntity
import com.splanes.apps.dutyfruty.data.features.groups.entity.GroupMemberEntity
import com.splanes.apps.dutyfruty.domain.features.groups.model.Group
import com.splanes.apps.dutyfruty.domain.features.groups.model.GroupColor
import com.splanes.apps.dutyfruty.domain.features.groups.model.GroupMember
import javax.inject.Inject

class GroupsMapper @Inject constructor() {

    fun map(entity: GroupMemberEntity): GroupMember =
        GroupMember(
            id = entity.id.orEmpty(),
            username = entity.username.orEmpty(),
            email = entity.email.orEmpty()
        )

    fun map(member: GroupMember): GroupMemberEntity =
        GroupMemberEntity(
            id = member.id,
            username = member.username,
            email = member.email
        )

    fun map(group: Group): GroupEntity =
        GroupEntity(
            id = group.id,
            owner = group.owner.id,
            alias = group.alias,
            members = group.members.map { m -> m.id },
            createdOn = group.createdOn,
            color = group.color.id,
        )

    fun map(entity: GroupEntity, members: List<GroupMemberEntity>): Group =
        Group(
            id = entity.id.orEmpty(),
            alias = entity.alias.orEmpty(),
            members = members.filter { m -> entity.members.orEmpty().contains(m.id) }.map(::map),
            createdOn = entity.createdOn ?: 0L,
            color = GroupColor.of(entity.color),
            owner = members.first { m -> m.id == entity.owner }.let(::map)
        )
}