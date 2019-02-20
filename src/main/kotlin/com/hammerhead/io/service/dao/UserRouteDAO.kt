package com.hammerhead.io.service.dao

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "user_route")
class UserRouteDAO {

    @EmbeddedId
    var pk : UserRoutePK? = null
}