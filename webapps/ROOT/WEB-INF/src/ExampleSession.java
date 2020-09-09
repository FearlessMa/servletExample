
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "session", urlPatterns = "/session")
public class ExampleSession extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 如果不存在 session 创建一个
    HttpSession session = req.getSession(true);
    long num = session.getCreationTime();
    Date time = new Date(num);
    // 获取该网页的最后一次访问时间
    Date lastAccessTime = new Date(session.getLastAccessedTime());
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sid = "sid";
    String count = "count";
    if (session.getAttribute(sid) == null) {
      String id = session.getId();
      session.setAttribute(sid, id);
    }
    String value = (String) session.getAttribute(sid);
    int countValue = session.getAttribute(count) != null ? (int) session.getAttribute(count) : 1;
    session.setAttribute(count, countValue + 1);
    resp.setContentType("text/html;charset=utf-8");
    Cookie cookieSid = new Cookie(sid, value);
    Cookie cookieCount = new Cookie(count, countValue + 1 + "");
    resp.addCookie(cookieSid);
    resp.addCookie(cookieCount);
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>session</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div>sid=" + sid + ",value=" + value + "</div>");
    out.println("<div>创建时间：" + format.format(time) + "</div>");
    out.println("<div>最后访问时间：" + format.format(lastAccessTime) + "</div>");
    out.println("<div>访问次数：" + (countValue + 1) + "</div>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
