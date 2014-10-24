package ejbs;

public class MyEJBImpl implements MyEJBLocal {

	@Override
	public String say(String msg) {
		return "voce disse: " + msg;
	}

}
