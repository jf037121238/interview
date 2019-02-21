package com.hammerhead.io.service.repository

import com.hammerhead.io.service.dao.ServiceDAO
import org.springframework.data.repository.CrudRepository

interface ServiceRepository : CrudRepository<ServiceDAO, Int>