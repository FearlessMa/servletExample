
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExampleCookie", urlPatterns = "/exampleCookie")
public class ExampleCookie extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    // 转发 存储session
    // RequestDispatcher rd = req.getRequestDispatcher("/session");
    // rd.include(req, resp);
    Cookie cookie = new Cookie("uid", "123");
    resp.addCookie(cookie);
    Cookie cookies[] = req.getCookies();

    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>cookie</title>");
    out.println("</head>");
    out.println("<body>");
    for (Cookie ck : cookies) {
      String name = ck.getName();
      String value = ck.getValue();
      out.println("<div>key=" + name + ",value=" + value + "</div>");
    }
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
