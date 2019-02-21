package com.hammerhead.io.service.dao

import javax.persistence.*

@Entity
@Table(name = "service_route")
class ServiceRouteDAO {

    @Id
    @GeneratedValue(generator = "service_route_id_seq")
    @SequenceGenerator(name = "service_route_id_seq", sequenceName = "service_route_id_seq", allocationSize = 1)
    @Column(name = "service_route_id")
    var serviceRouteId : Int ? = null

    @ManyToOne
    @JoinColumn(name = "service_id")
    lateinit var service : ServiceDAO

    @ManyToOne
    @JoinColumn(name = "route_id")
    lateinit var route : RouteDAO
}