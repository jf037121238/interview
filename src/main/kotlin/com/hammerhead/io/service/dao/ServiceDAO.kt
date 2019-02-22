package com.hammerhead.io.service.dao

import javax.persistence.*

@Entity
@Table(name = "service")
class ServiceDAO {

    @Id
    @GeneratedValue(generator = "service_seq")
    @SequenceGenerator(name = "service_seq", sequenceName = "service_seq", allocationSize = 1)
    @Column(name = "service_id")
    var serviceId : Int ? = null

    @Column(name = "service")
    lateinit var service : String


    @Column(name = "user_string")
    @Enumerated(EnumType.STRING)
    lateinit var userPrependEnum: ServiceUserPrependEnum

}