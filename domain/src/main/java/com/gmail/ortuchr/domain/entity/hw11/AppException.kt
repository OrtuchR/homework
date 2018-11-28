package com.gmail.ortuchr.domain.entity.hw11

import com.gmail.ortuchr.domain.entity.DomainEntity
import java.lang.Exception

data class AppException(
        val errorType: AppErrorType) : Exception(), DomainEntity