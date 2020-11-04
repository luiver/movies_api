package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.service.GenericService;
import com.codecool.moviesapi.service.LoggerService;
import com.codecool.moviesapi.service.MailingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {
    MailingService mailingService;
    LoggerService loggerService;
    static Logger log = Logger.getLogger(GenericService.class.getName());

    @RequestMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String message = "unknown error";

        if (status != null) {
            String error = status.toString();
            message = error + " " + HttpStatus.valueOf(Integer.parseInt(error)).getReasonPhrase();
            log.info(message);
            sendMailIfServerError(status);
        }
        return message;
    }

    private void sendMailIfServerError(Object status) {
        int statusCode = Integer.parseInt(status.toString());
        if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            String tenLast = loggerService.getTenLastRowsFromLogFile();
            mailingService.sendDefaultSeverErrorMessage(tenLast);
        }
    }

    @Override
    public String getErrorPath() {
        return null;
    }

    @Autowired
    public void setMailingService(MailingService mailingService) {
        this.mailingService = mailingService;
    }

    @Autowired
    public void setLoggerService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }
}
