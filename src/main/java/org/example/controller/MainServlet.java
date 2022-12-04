package org.example.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.command.Command;
import org.example.command.CommandResponse;

import java.io.IOException;

@WebServlet("/controller")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 3937496878618720002L;
    private static final Logger LOG = LogManager.getLogger(MainServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.trace("caught req and resp in doGet method");

        final String commandName = req.getParameter("command");
        Command command = Command.of(commandName);
        CommandResponse response = command.execute(null);

        try {
            if (response.isRedirect()) {
                resp.sendRedirect(response.getPath());
            } else {
                final String desiredPath = response.getPath();
                final RequestDispatcher dispatcher = req.getRequestDispatcher(desiredPath);
                dispatcher.forward(req, resp);
            }
        } catch (ServletException e) {
            LOG.error("servlet exception occurried", e);
        } catch (IOException e) {
            LOG.error("IO exception occurred", e);
        }
    }
}

