import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyConfig", urlPatterns = "/config")
public class Config extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    // super.doGet(req, resp);
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();
    ServletConfig sc = this.getServletConfig();
    //  获取xml中的 servlet-name  MyConfig
    String servletName = sc.getServletName();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>config</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div>sName：" + servletName + "</div>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
