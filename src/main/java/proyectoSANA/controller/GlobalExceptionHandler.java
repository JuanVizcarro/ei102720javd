package proyectoSANA.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ModelAndView handleNotFoundError(HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("error/exceptionError");
        return mav;
    }
}
