package br.com.testes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.testes.ejb.MyEJBInterface;
import br.com.testes.util.EJBUtil;

@WebServlet("/teste")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	MyEJBInterface ejb = null;

	public void init() throws ServletException {
	}

	private MyEJBInterface getEJB() throws NamingException {
		//"java:/openejb/Deployment/myejb/br.com.testes.ejb.MyEJBInterface"
		//"java:/module/myejb!br.com.testes.ejb.MyEJBInterface"

		if (ejb == null) {
			Properties p = new Properties();
			p.put("java.naming.factory.initial","org.apache.openejb.client.LocalInitialContextFactory");
			InitialContext ctx = new InitialContext(p);
			ejb = (MyEJBInterface) ctx.lookup("java:/openejb/Deployment/myejb/br.com.testes.ejb.MyEJBInterface");
		}
		return ejb;
	}

	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		HttpSession session = req.getSession(true);
		ejb = (MyEJBInterface) session.getAttribute("ejb");
		if(ejb == null){
			try {
				ejb = this.getEJB();
				session.setAttribute("ejb", ejb);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		


		String acao = req.getParameter("acao");
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		if ("say".equalsIgnoreCase(acao)) {
			printReturn(pw, ejb.say(" hello!!!"));
			
		} else if ("list".equalsIgnoreCase(acao)) {
			printReturn(pw, ejb.obterMensagens().toString());
			
		} else if ("free".equalsIgnoreCase(acao)) {
			ejb.liberarSesssao();
			session.removeAttribute("ejb");
			printReturn(pw, "sessao liberada!!!");
			
		} else if ("lookup".equalsIgnoreCase(acao)) {
			try{
				Properties p = new Properties();
				p.put("java.naming.factory.initial","org.apache.openejb.client.LocalInitialContextFactory");
				InitialContext ctx = new InitialContext(p);
				String url = req.getParameter("url");
				ejb = (MyEJBInterface) ctx.lookup(url.replace("'", ""));
			} catch(Exception ex){
				ex.printStackTrace();
			}
			
		} else if ("listlookup".equalsIgnoreCase(acao)) {
			List<String> contexts = EJBUtil.listContexts();
			for(String context : contexts){
				printReturn(pw, "--> " + context + "<br/>");
			}
			
		}	else {
			printReturn(pw, "<h1> TESTE EJB DE SESSAO. </h1> <br/>");
			printReturn(pw, "opcoes <br/>");
			printReturn(pw, "============================================================================= <br/>");
			printReturn(pw, "<a href="+ resp.encodeURL(req.getContextPath()+"/teste?acao=say") +">  1-say   </a> <br/>");
			printReturn(pw, "<a href='"+ resp.encodeURL(req.getContextPath()+"/teste?acao=list") +"'> 2-list </a>  <br/>");
			printReturn(pw, "<a href='"+ resp.encodeURL(req.getContextPath()+"/teste?acao=free") +"'> 3-free </a> <br/>");
			printReturn(pw, "<a href='"+ resp.encodeURL(req.getContextPath()+"/teste?acao=lookup") +"'> 4-lookup (para testes de lookup) </a> <br/>");
			printReturn(pw, "<a href='"+ resp.encodeURL(req.getContextPath()+"/teste?acao=listlookup") +"'> 5-listlookup (para listar os pontos de acesso do EJB) </a>");
			
		}
	}

	private void printReturn(PrintWriter pw, String msg) {
		pw.println(msg);
	}

}
