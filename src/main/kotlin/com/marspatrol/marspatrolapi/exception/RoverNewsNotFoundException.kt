package com.marspatrol.marspatrolapi.exception

import org.springframework.http.HttpStatus

class RoverNewsNotFoundException(newsId: Int): BaseException(
    HttpStatus.NOT_FOUND,
    ApiError(
        errorCode = "rovernews.not.found",
        description = "Rover news not found with id=$newsId"
    )
)