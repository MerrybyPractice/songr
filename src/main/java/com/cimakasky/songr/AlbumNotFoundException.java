package com.cimakasky.songr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AlbumNotFoundException extends Throwable {

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Album Not Found")
    public class BugNotFoundException extends RuntimeException{

    }
}
