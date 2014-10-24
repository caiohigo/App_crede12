package br.ufc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		req.setCharacterEncoding("UTF-8");
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		HttpSession session = req.getSession(false);
		String contextPath = req.getContextPath();

		if (uri.contains("/adm/")) {
			if (session != null) {
				if (session.getAttribute("nome") == null) {
					resp.sendRedirect(contextPath + "/login.xhtml");
				} else {
					chain.doFilter(request, response);
				}
			} else {
				resp.sendRedirect(contextPath + "/login.xhtml");
			}
		}else {
			chain.doFilter(request, response);
		}
		

		/*if (path.toLowerCase().contains("login")
				|| path.toLowerCase().contains("javax.faces.resource")) {
			chain.doFilter(request, response);
		} else if (session != null && session.getAttribute("nome") != null) {
			chain.doFilter(request, response);
		} else {
			String contextPath = ((HttpServletRequest) request)
					.getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath
					+ "/login.xhtml");
		}*/
	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
