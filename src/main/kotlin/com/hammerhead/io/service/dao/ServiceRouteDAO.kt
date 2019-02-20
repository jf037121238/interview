package com.hammerhead.io.service.dao

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "service_route")
class ServiceRouteDAO {

    @EmbeddedId
    var pk : ServiceRoutePK? = null
}