package com.hammerhead.io.service.dao

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "user_service_route")
class UserServiceRouteDAO {

    @EmbeddedId
    lateinit var pk: UserServiceRoutePK
}