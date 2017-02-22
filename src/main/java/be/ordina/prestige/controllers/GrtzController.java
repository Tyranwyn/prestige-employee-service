package be.ordina.prestige.controllers;

import be.ordina.prestige.model.Grtz;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by SaFu on 22/02/2017.
 */
@RestController
public class GrtzController {

    private static final String template = "Greetings u little, %s";
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value = "getGreeting", nickname = "getGreeting")
    @RequestMapping(method = RequestMethod.GET, path = "/grtz", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue = "Dildo"),
            @ApiImplicitParam(name = "lastname", value = "User's last name", required = false, dataType = "string", paramType = "query", defaultValue = "Swaggins")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Poortje is open ;)", response = Grtz.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public Grtz grtz(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Grtz(counter.incrementAndGet(), String.format(template, name));
    }

}
