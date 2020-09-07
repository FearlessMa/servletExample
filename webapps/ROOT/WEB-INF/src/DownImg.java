
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DownImg", urlPatterns = "/down")
public class DownImg extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String filePath = "/tomcat.gif";
    ServletContext context = this.getServletConfig().getServletContext();
    String realPath = context.getRealPath(filePath);
    FileInputStream fis = new FileInputStream(realPath);
    ServletOutputStream sos = resp.getOutputStream();
    String filename = filePath.substring(filePath.lastIndexOf("\\") + 1);
    System.out.println("filePath：" + filePath);
    System.out.println("filename："+filename);
    filename = URLEncoder.encode(filename, "UTF-8");// 将不安全的文件名改为UTF-8格式
    resp.setHeader("content-disposition", "attachment;filename=" + filename);
    resp.setHeader("content-type", "image/gif");

    // resp.setContentType("");
    // 执行输出操作
    int len = 1;
    byte[] b = new byte[1024];
    while ((len = fis.read(b)) != -1) {
      sos.write(b, 0, len);
    }
    sos.close();
    fis.close();
  }
}
