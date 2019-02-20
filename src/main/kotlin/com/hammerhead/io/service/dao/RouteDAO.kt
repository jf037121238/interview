package com.hammerhead.io.service.dao

import javax.persistence.*

@Entity
@Table(name = "route")
class RouteDAO {

    @Id
    @GeneratedValue(generator = "route_seq")
    @SequenceGenerator(name = "route_seq", sequenceName = "route_seq", allocationSize = 1)
    @Column(name = "route_id")
    var routeId: Int? = null

    @Column(name = "route")
    var route : String ? = null

}