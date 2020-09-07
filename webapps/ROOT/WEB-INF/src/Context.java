
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "context", urlPatterns = "/context")
public class Context extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    // super.doGet(req, resp);
    resp.setContentType("text/html;utf-8");
    PrintWriter out = resp.getWriter();
    ServletContext context = getServletConfig().getServletContext();
    String path = context.getRealPath("/WEB-INF/web.xml");
    Enumeration<String> enumStr = context.getInitParameterNames();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>AnnoServlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div>context</div>");
    out.println("<div>Servlet MyFirstServlet at " + req.getContextPath() + "</div>");
    out.println("<div>Servlet web.xml realPath =" + path + "</div>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
