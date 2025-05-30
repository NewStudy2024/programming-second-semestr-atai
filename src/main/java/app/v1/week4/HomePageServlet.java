package app.v1.week4;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import freemarker.template.*;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.*;

public class HomePageServlet extends HttpServlet {
    private Configuration cfg;
    private ProductManager manager;

    public HomePageServlet(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public void init() {
        cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "templates");
        cfg.setDefaultEncoding("UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Template template = cfg.getTemplate("home.ftl");
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Welcome to Home Page");
        model.put("products", manager.getProducts());

        resp.setContentType("text/html");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
