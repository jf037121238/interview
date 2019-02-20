package com.hammerhead.io.service.dao

import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Embeddable
class UserRoutePK constructor() : Serializable {

    @ManyToOne
    @JoinColumn(name = "users_id")
    var user : UserDAO? = null

    @ManyToOne
    @JoinColumn(name = "route_id")
    var route : RouteDAO ? = null

}