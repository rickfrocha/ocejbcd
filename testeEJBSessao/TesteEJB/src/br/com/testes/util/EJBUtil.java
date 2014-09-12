package br.com.testes.util;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;

public class EJBUtil {
	 
	static  List<String> contexts = null;
	
	/***
	 * Método utilitario que serve para descobrir o nome dos recursos no container EJB.
	 * Utilizado quando se precisa acessar o EJB e tem dificuldade para descobri-lo
	 * @return
	 */
	public static List<String> listContexts() {
		contexts = new ArrayList<String>();
		try {
			Context ctx = new InitialContext();
			String n = ctx.getNameInNamespace();
			_print(n);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
		return contexts;
	}

	private static void _print(String name) throws Exception {
		try {
			if(!"".equals(name)){
				contexts.add(name);
			}
			
			Context ctx = new InitialContext();
			NamingEnumeration<Binding> list = ctx.listBindings(name);

			while (list.hasMoreElements()) {
				Binding b = list.nextElement();
				String s = b.getName();

				_print(name + "/" + s);
			}

		} catch (Exception ex) {
			
		}
	}
	

}
