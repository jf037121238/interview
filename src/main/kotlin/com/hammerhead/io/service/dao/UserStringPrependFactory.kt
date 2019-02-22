package com.hammerhead.io.service.dao

class UserStringPrependFactory {

    companion object {
        fun prependUserString(userServiceRouteDAO: UserServiceRouteDAO) : String {
            return "${userServiceRouteDAO.pk.user.usersId}${userServiceRouteDAO.pk.serviceRouteDAO.route.route}"
        }

        fun postPendUserString(userServiceRouteDAO: UserServiceRouteDAO) : String {
            return "${userServiceRouteDAO.pk.serviceRouteDAO.route.route}${userServiceRouteDAO.pk.user.usersId}"
        }
    }
}