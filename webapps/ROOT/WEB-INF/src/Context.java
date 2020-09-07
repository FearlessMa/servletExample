
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;

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
    resp.setContentType("text/html;charset=UTF-8");
    // 获取写入对象
    PrintWriter out = resp.getWriter();
    // 获取context
    ServletContext context = getServletConfig().getServletContext();
    // 获取真实路径
    String path = context.getRealPath("/WEB-INF/web.xml");
    // 获取初始参数配置
    Enumeration<String> enumStr = context.getInitParameterNames();
    // 获取指定资源内容
    InputStream in = context.getResourceAsStream("/WEB-INF/web.xml");
    InputStreamReader isr = new InputStreamReader(in, "UTF-8");
    BufferedReader bfr = new BufferedReader(isr);
    String str = null;
    // 获取指定路径下内容
    Set<String> set = context.getResourcePaths("/WEB-INF");
    Iterator it = set.iterator();

    // 返回的html文件
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>AnnoServlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div>context 12</div>");
    out.println("<div>Servlet MyFirstServlet at " + req.getContextPath() + "</div>");
    out.println("<div>Servlet web.xml realPath =" + path + "</div>");
    System.out.println("124");
    System.out.println(enumStr.hasMoreElements());
    while (enumStr.hasMoreElements()) {
      Object next = enumStr.nextElement();
      out.println("<div>Servlet web.xml realPath =" + next + "</div>");
    }
    out.println("<div>web.xml");
    while ((str = bfr.readLine()) != null) {
      out.println("<div> " + str + "</div>");
    }
    out.println("</div>");

    out.println("<div> 指定路径下文件");
    while (it.hasNext()) {
      out.println("<div>" + it.next() + "</div>");
    }
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
