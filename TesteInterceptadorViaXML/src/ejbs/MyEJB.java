package ejbs;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class MyEJB {
	
	@EJB SayEJB sayEJB;
	
	public String say(String name){
		return sayEJB.say(name);
	}

}
