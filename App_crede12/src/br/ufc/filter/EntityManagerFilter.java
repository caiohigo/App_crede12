package br.ufc.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import br.ufc.utils.JPAUtils;
 
@WebFilter("/*")
public class EntityManagerFilter implements Filter {
  public void doFilter(ServletRequest request, ServletResponse response,
           FilterChain chain) throws IOException, ServletException {
    try {
      JPAUtils.beginTransaction();
      chain.doFilter(request, response);
      JPAUtils.commit();
    } catch (Throwable e) {
      System.out.println(e.getMessage() + "\n" + e.getCause());
      e.printStackTrace();
      JPAUtils.rollback();
      throw new ServletException(e);
    } finally {
      JPAUtils.closeEntityManager();
    }
  }
 
  public void destroy() {}
  public void init(FilterConfig arg0) throws ServletException {}
}