package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.service.GenericService;
import org.apache.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {
    static Logger log = Logger.getLogger(GenericService.class.getName());

    @RequestMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String message;

        if (status != null) {
            String error = status.toString();

            message = error + " " + HttpStatus.valueOf(Integer.parseInt(error)).getReasonPhrase();
            log.info(message);
            return message;
        }
        message = "unknown error";
        return message;
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
