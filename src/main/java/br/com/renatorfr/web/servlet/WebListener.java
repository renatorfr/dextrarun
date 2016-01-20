package br.com.renatorfr.web.servlet;

import br.com.renatorfr.web.common.Binder;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebListener extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Scanner scanner = new Scanner(req.getInputStream(), req.getCharacterEncoding());
        PrintWriter output = resp.getWriter();
        Gson gson = new Gson();
        try {
            Binder binder = new Binder(req.getRequestURI().replace(req.getContextPath(), ""));
            Object object = binder.invoke(scanner.nextLine());
            String json = gson.toJson(object);
            resp.setCharacterEncoding("utf8");
            resp.setContentType("application/json");
            output.println(json);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getCause().getMessage());
        } finally {
            scanner.close();
            output.flush();
            output.close();
        }
    }
}
