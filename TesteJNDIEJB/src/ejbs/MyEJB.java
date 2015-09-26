package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@LocalBean
@Stateless
public class MyEJB {
	
	public String say(String msg){
		return "Say "+ msg;
	}

}
