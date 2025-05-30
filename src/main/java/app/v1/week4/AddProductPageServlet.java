package app.v1.week4;

import freemarker.template.Configuration;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddProductPageServlet extends HttpServlet {
    private Configuration cfg;
    private ProductManager manager;

    public AddProductPageServlet(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public void init() {
        cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "templates");
        cfg.setDefaultEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        manager.addProduct(new Product(name, quantity));
        resp.sendRedirect("/");
    }
}
