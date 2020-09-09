
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "result", urlPatterns = "/result")
public class Login extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();
    Map<String, String[]> pMap = req.getParameterMap();
    Set<String> keySet = pMap.keySet();
    Iterator<String> it = keySet.iterator();
    String userName = req.getParameter("userName");
    String password = req.getParameter("password");
    Enumeration<String> names = req.getParameterNames();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>result</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div>userName = " + userName + "</div>");
    out.println("<div>password = " + password + "</div>");
    if (it.hasNext()) {
      String key = it.next();
      String[] values = pMap.get(key);
      out.println("<div>key = " + key + "value=" + values[0] + "</div>");
    }
    while (names.hasMoreElements()) {
      Object next = names.nextElement();
      out.println("<div>name " + next + "</div>");
    }
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // resp.setContentType("application/json");
    // PrintWriter out = resp.getWriter();
    // out.println("{code:200}");
    // out.close();
    doGet(req, resp);
  }

}
