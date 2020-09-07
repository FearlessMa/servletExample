import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//  转发
@WebServlet(name = "Dispatch", urlPatterns = "/dispatch")
public class Dispatch extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 500 错误码
    resp.setStatus(500);
    resp.setContentType("text/html;charset=utf-8");
    // 获得转发对象
    RequestDispatcher rd = req.getRequestDispatcher("/anno");
    // 调用转发对象方法 执行请求处理
    // rd.forward(req, resp);
    // 包含请求的操作，可以继续执行其他操作
    rd.include(req, resp);
    PrintWriter out = resp.getWriter();
    out.println("<script>console.log('dispatch');</script>");
    out.close();
  }
}
