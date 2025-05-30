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

public class DetailPageServlet extends HttpServlet {
    private Configuration cfg;
    private ProductManager manager;

    public DetailPageServlet(ProductManager manager) {
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

        // Use index to get product
        Product selected = manager.getProducts().get(index);

        Map<String, Object> model = new HashMap<>();
        model.put("title", "Product Details %s".formatted(selected.getName()));
        model.put("product", selected);

        Template template = cfg.getTemplate("detail.ftl");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
