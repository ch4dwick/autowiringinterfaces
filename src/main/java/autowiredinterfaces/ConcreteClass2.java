package autowiredinterfaces;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class ConcreteClass2 implements Interface {
	private static final Logger LOGGER = Logger.getLogger(ConcreteClass2.class.getName());

	@Override
	public void doSomething() {
		LOGGER.log(Level.INFO, "I am ConcreteClass2.");
	}

}
