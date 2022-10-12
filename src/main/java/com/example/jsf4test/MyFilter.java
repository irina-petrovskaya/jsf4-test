package com.example.jsf4test; /**
 * *
 * <p>Created by irina on 10/4/2022.</p>
 * <p>Project: jsf4-test</p>
 * *
 */

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "MyFilter")
public class MyFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
