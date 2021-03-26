package co.com.sofka.parques.infrastructure.command;

import co.com.sofka.application.ApplicationCommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommandController {

    private static final Logger logger = Logger.getLogger(CommandController.class.getName());
    @Autowired
    private ApplicationCommandExecutor applicationCommandExecutor;

    @PostMapping(value = "command", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void command(@RequestBody final Map<String, String> args )  {

            applicationCommandExecutor.execute(args);

    }
}