package com.hammerhead.io.service.repository

import com.hammerhead.io.service.dao.UserServiceRouteDAO
import org.springframework.data.repository.CrudRepository

interface UserServiceRouteRepository : CrudRepository<UserServiceRouteDAO, Int> {

    fun findAllByPk_User_UsersId(userId : Int) : List<UserServiceRouteDAO>

    fun findAllByPk_User_UsersIdAndPk_ServiceRouteDAO_Service_ServiceIn(userId: Int, services : List<String>) : List<UserServiceRouteDAO>
}