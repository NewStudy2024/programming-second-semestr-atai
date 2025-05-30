package app.v1.week4;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DeleteProductPageServlet extends HttpServlet {
    private Configuration cfg;
    private ProductManager manager;

    public DeleteProductPageServlet(ProductManager manager) {
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
        String indexParam = req.getParameter("index");

        int index = Integer.parseInt(indexParam); // ⚠️ Add error handling in real apps

        manager.deleteProduct(index);

        resp.sendRedirect("/");
    }
}
