package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ErrorController
 * 
 * Create by TienTV5, Copy by PhucTV7
 *
 * Date: 20-04-2020
 *
 * Copyright
 *
 * 
 * 
 */
@Controller
public class ErrorController {
    
    @RequestMapping(value = "/errors", method = RequestMethod.GET)
    public String renderErrorPage(HttpServletRequest httpRequest, Model model) {

        String errorCode = "";
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
            case 400:
                errorCode = "400";
                errorMsg = "Bad Request.";
                break;

            case 401:
                errorCode = "401";
                errorMsg = "Unauthorized.";
                break;

            case 404:
                errorCode = "404";
                errorMsg = "Page not found.";
                break;

            case 500:
                errorCode = "500";
                errorMsg = "Internal Server Error.";
                break;

            default:
                errorCode = "";
                errorMsg = "Oops! Something went wrong.";
                break;
        }
        model.addAttribute("errorMessage", errorMsg);
        model.addAttribute("errorCode", errorCode);
        return "error-page";
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
    }
}