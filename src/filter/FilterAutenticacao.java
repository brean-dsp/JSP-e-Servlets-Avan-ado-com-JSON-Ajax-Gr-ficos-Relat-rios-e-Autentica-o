package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import user.UserLogado;

@WebFilter(urlPatterns={"/pages/acessoAoSistema.jsp"})
public class FilterAutenticacao implements Filter{

	//intercepta todas as requisi��es
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		//retorna null caso n�o esteja logado
		UserLogado userLogado = (UserLogado) session.getAttribute("usuario");
		
		if(userLogado == null) {//usuario n�o logado
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticar.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		// n�o esquecer de substituir os args0, args1 e args2 por request, response e chain
		//executa as a��es do request response
		chain.doFilter(request, response);
		
		System.out.println("Interceptando");
	}

}
