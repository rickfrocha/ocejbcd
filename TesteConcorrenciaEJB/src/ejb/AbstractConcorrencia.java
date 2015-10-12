package ejb;

import java.util.Date;

/**
 * 
 */

/**
 * @author Ricardo Rocha
 * @since 06/10/2015
 * 
 */
public abstract class AbstractConcorrencia {

	private void aguardarEmSegundos(final long inSecondsDelay) {
		try {
			Thread.sleep(1000L * inSecondsDelay);
		} catch (InterruptedException e) {
			// Ignore exceptions.
		}
	}

	public void slowMethod() {
		System.out.println("Iniciando slow method " + new Date()
				+ " instancia " + this);
		aguardarEmSegundos(10L);
		System.out.println("finalizando slow method " + new Date()
				+ " instancia " + this);
	}

	public void fastMethod() {
		System.out.println("Iniciando fast method " + new Date()
				+ " instancia " + this);
		aguardarEmSegundos(1L);
		System.out.println("finalizando fast method " + new Date()
				+ " instancia " + this);
	}

}
