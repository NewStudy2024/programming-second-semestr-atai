package app.v1.week4;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;




public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ProductManager productManager = new ProductManager();
        productManager.addProduct(new Product("Apple", 20));
        productManager.addProduct(new Product("Banana", 300));
        productManager.addProduct(new Product("DragonFruit", 100));

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.addServlet(new ServletHolder(new HomePageServlet(productManager)), "/");
        handler.addServlet(new ServletHolder(new DetailPageServlet(productManager)), "/detail");
        handler.addServlet(new ServletHolder(new AddProductPageServlet(productManager)), "/addProduct");
        handler.addServlet(new ServletHolder(new DeleteProductPageServlet(productManager)), "/delete");

        server.setHandler(handler);
        server.start();
        server.join();
    }

}
