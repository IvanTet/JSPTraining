package org.example;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cool-servlet")
public class MainServlet extends HttpServlet {
private static final long serialVersionUID = 3937496878618720002L;
private static final Logger LOG = LogManager.getLogger(MainServlet.class);
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    LOG.trace("caught req and resp in doGet method");
    try (final PrintWriter writer = resp.getWriter()){
        writer.println("<html><head></head>" +
                "<body><h1>Hello World</h1><p>sent by cool-servlet</p></body>" +
                "</html>");
    } catch (IOException e) {
        LOG.error("IO exception occurred", e);
    }

}

}