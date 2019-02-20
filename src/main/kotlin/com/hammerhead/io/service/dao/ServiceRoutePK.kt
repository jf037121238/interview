package com.hammerhead.io.service.dao

import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Embeddable
class ServiceRoutePK constructor() : Serializable {

    @ManyToOne
    @JoinColumn(name = "service_id")
    var service : ServiceDAO? = null

    @ManyToOne
    @JoinColumn(name = "route_id")
    var route : RouteDAO? = null

}