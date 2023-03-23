package com.splanes.apps.dutyfruty.data.features.groups.datasource.impl

import com.splanes.apps.dutyfruty.data.features.groups.entity.GroupEntity
import com.splanes.apps.dutyfruty.data.features.groups.entity.GroupMemberEntity

object GroupsCache {

    private val _members: MutableList<GroupMemberEntity> = mutableListOf()
    val members: List<GroupMemberEntity> get() = _members

    private val _groups: MutableList<GroupEntity> = mutableListOf()
    val groups: List<GroupEntity> get() = _groups

    fun saveOne(member: GroupMemberEntity) {
        if (_members.none { m -> m.id == member.id }) {
            _members.add(member)
        }
    }

    fun saveOne(group: GroupEntity) {
        if (_groups.none { g -> g.id == group.id }) {
            _groups.add(group)
        }
    }

    @JvmName("saveAllMembers")
    @JvmStatic
    fun saveAll(members: List<GroupMemberEntity>) {
        members
            .filter { m -> _members.none { it.id == m.id } }
            .run(_members::addAll)
    }

    @JvmName("saveAllGroups")
    @JvmStatic
    fun saveAll(groups: List<GroupEntity>) {
        groups
            .filter { g -> _groups.none { it.id == g.id } }
            .run(_groups::addAll)
    }
}
