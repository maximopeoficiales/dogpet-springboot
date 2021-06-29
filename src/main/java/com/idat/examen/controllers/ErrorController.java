package com.idat.examen.controllers;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;

@ControllerAdvice
public class ErrorController {
    // filtro de excepcion not found 404
    // retorna una pagina templates/error
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String exception(final Throwable throwable, final Model model) {
        // logger.error("Exception during execution of SpringSecurity application",
        // throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

    // filtro de excepcion INTERNAL_SERVER_ERROR 500
    // retorna una pagina templates/error
    // @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionError(final Throwable throwable, final Model model) {
        // logger.error("Exception during execution of SpringSecurity application",
        // throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

}
