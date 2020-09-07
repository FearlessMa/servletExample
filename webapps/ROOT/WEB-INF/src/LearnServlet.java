

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class LearnServlet extends HttpServlet {

  private static final long serialVersionUID = -1915463532411657451L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    try {
      // Write some content
      out.println("<html>");
      out.println("<head>");
      out.println("<title>MyFirstServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h2>Servlet MyFirstServlet at " + req.getContextPath() + "</h2>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
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
}
