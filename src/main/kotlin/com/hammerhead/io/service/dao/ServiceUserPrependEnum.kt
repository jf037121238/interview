package com.hammerhead.io.service.dao

import com.hammerhead.io.service.dao.UserStringPrependFactory.Companion.postPendUserString
import com.hammerhead.io.service.dao.UserStringPrependFactory.Companion.prependUserString


enum class ServiceUserPrependEnum(val userStringFunction: (UserServiceRouteDAO) -> String) {

    PREPEND(::prependUserString),
    POSTPEND(::postPendUserString)
    ;


}