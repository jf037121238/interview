package com.hammerhead.io.service.dao

import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Embeddable
class UserServiceRoutePK : Serializable {

    @ManyToOne
    @JoinColumn(name = "service_route_id")
    lateinit var serviceRouteDAO: ServiceRouteDAO

    @ManyToOne
    @JoinColumn(name = "user_id")
    lateinit var user : UserDAO

}