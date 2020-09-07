import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// 引入注解

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AnnoServlet", urlPatterns = { "/anno" })
public class AnnoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");

    PrintWriter out = resp.getWriter();
    Map<String, String> data = getMap();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>AnnoServlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div>注解</div>");
    out.println("<h2>Servlet MyFirstServlet at " + req.getContextPath() + "</h2>");
    out.println("<div>userName:" + data.get("userName") + "</div>");
    out.println("<div>message:" + data.get("message") + "</div>");
    out.println("<div>date:" + new Date() + "</div>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    super.doPost(req, resp);
  }

  @Override
  public String getServletInfo() {
    // TODO Auto-generated method stub
    return "MyFirstServlet";
  }

  private Map<String, String> getMap() {
    Map<String, String> data = new HashMap<>();
    data.put("userName", "users");
    data.put("message", "this is message");
    return data;
  }
}
