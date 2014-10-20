package ejbs;

import java.io.Serializable;
import java.util.concurrent.Future;

public interface GeradorMsg extends Serializable {
	
	Future<String> generate();
	void ping();

}
