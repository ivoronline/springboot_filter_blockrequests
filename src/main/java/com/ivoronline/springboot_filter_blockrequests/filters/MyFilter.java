package com.ivoronline.springboot_filter_blockrequests.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MyFilter extends OncePerRequestFilter {

  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws IOException, ServletException {

    //LOG
    System.out.print("CHECKING REQUEST PARAMETERS: " + request.getQueryString());

    //GET REQUESTS PARAMETERS
    String parameterUsername = request.getParameter("username");

    //CHECK REQUESTS PARAMETERS
    if(parameterUsername == null) {
      System.out.println(" (Parameter username missing)");
      response.getWriter().println("Parameter username missing");
      return;
    }
    System.out.println("  (Parameter username found)");

    //FORWARD TO CONTROLLER
    chain.doFilter(request, response);

  }

}
