package co.com.sofka.parques.infrastructure.command;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice(annotations= RestController.class)
public class ErrorRestControllerAdvice {
  
    private static final Logger logger = Logger.getLogger(ErrorRestControllerAdvice.class.getName());
    
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseError handleException(RuntimeException ex, HttpServletRequest request) {
        logger.log(Level.SEVERE, ex.getMessage(), ex);
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
  
        return new ResponseError(
                HttpStatus.BAD_REQUEST.value(),
                "BAD REQUEST",
                ex.getMessage(),
                request.getRequestURI());
    }
 
}