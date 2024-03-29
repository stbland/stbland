/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3-sd:src/main/java/web/interceptor/UserContextInterceptor.p.vm.java
 */
package fr.cora.mesindicateurssi.web.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;

import fr.cora.mesindicateurssi.util.LogContext;
import fr.cora.mesindicateurssi.web.util.UserContextUtil;

/**
 * Expose the 'userContext' bean to the view and bind contextual info for logs.
 */
@Service
public class UserContextInterceptor implements HandlerInterceptor {

    @Autowired
    private UserContextUtil userContext;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException {
        request.setAttribute("userContext", userContext);
        LogContext.setLogin(userContext.getUsername() != null ? userContext.getUsername() : "no username");
        LogContext.setSessionId(request.getSession().getId());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        LogContext.resetLogContext();
    }
}