package main.com.FriendHub.Utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
@SuppressWarnings("serial")
public class ForbiddenException extends RuntimeException {

}
