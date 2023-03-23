package com.splanes.apps.dutyfruty.data.features.groups.repository

import com.splanes.apps.dutyfruty.data.features.groups.datasource.GroupsDataSource
import com.splanes.apps.dutyfruty.data.features.groups.datasource.impl.GroupsCache
import com.splanes.apps.dutyfruty.data.features.groups.entity.mapper.GroupsMapper
import com.splanes.apps.dutyfruty.domain.features.groups.model.Group
import com.splanes.apps.dutyfruty.domain.features.groups.model.GroupMember
import com.splanes.apps.dutyfruty.domain.features.groups.repository.GroupsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GroupsRepositoryImpl @Inject constructor(
    private val mapper: GroupsMapper,
    private val dataSource: GroupsDataSource,
    private val cache: GroupsCache
) : GroupsRepository {

    override suspend fun saveGroupMember(member: GroupMember) =
        withContext(Dispatchers.IO) {
            val entity = member.let(mapper::map)
            dataSource.saveGroupMember(entity)
            cache.saveOne(entity)
        }

    override suspend fun getMembers(emails: List<String>): List<GroupMember> {
        val members = cache.members.ifEmpty {
            dataSource
                .getAllMembers()
                .also(cache::saveAll)
        }
    }

    override suspend fun saveGroup(group: Group) =
        withContext(Dispatchers.IO) {
            val entity = group.let(mapper::map)
            dataSource.saveGroup(entity)
            cache.saveOne(entity)
            TODO()
        }

    override suspend fun editGroup(group: Group) {
        TODO("Not yet implemented")
    }

    override suspend fun removeGroup(group: Group) {
        TODO("Not yet implemented")
    }
}