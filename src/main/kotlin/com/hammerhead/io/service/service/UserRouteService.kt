package com.hammerhead.io.service.service

import com.hammerhead.io.service.repository.UserServiceRouteRepository
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

@Component
@Lazy
class UserRouteService(val userServiceRouteRepository: UserServiceRouteRepository) {

    /**
     * returns a list of user routes based on the given userId and an optional
     * comma separated list of services
     */
    fun get(userId: Int, service: String?): List<String> {
        return if (null != service) {
            userServiceRouteRepository
                    .findAllByPk_User_UsersIdAndPk_ServiceRouteDAO_Service_ServiceIn(userId, service.split(","))
        } else {
            userServiceRouteRepository.findAllByPk_User_UsersId(userId)
        }.map { it.pk.serviceRouteDAO.service.userPrependEnum.userStringFunction(it) }
    }
}