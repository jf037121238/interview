package com.hammerhead.io.service.dao

import javax.persistence.*

@Entity
@Table(name = "users")
class UserDAO {

    @Id
    @GeneratedValue(generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @Column(name = "user_id")
    var usersId : Int ? = null


    @Column(name = "user_name")
    lateinit var userName : String
}