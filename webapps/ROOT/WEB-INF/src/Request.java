import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// https://juejin.im/post/6844903740999204877
@WebServlet(name = "request", urlPatterns = "/request")
public class Request extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();
    //  根据 name 获取值
    String origin = req.getHeader("Origin");
    //  获取所有头部 name
    Enumeration<String> hNames = req.getHeaderNames();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>config</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div>origin ：" + origin + "</div>");
    while (hNames.hasMoreElements()) {
      String name = hNames.nextElement();
      String value = req.getHeader(name);
      out.println("<div>" + name + ":" + value + "</div>");
    }
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
