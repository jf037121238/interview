package com.hammerhead.io.service.repository

import com.hammerhead.io.service.dao.UserDAO
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserDAO, Int>