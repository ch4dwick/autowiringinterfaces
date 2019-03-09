package autowiredinterfaces;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is where all the magic happens.
 * @author Chad
 *
 */
@Service
public class InterfaceLoader {
	/**
	 * All the instances of your interface are here. :)
	 */
	@Autowired
	protected Set<Interface> interfaces;
	
	/**
	 * Load a concrete instance of the Interface interface. 
	 * @param clazz
	 * @return
	 * @throws ClassNotFoundException Exception returned when a class doesn't exist.
	 */
	public Interface loadClass(String clazz) throws ClassNotFoundException {
		return interfaces
				.stream()
				.filter(type -> type.getClass().getSimpleName().equals(clazz))
				.findFirst()
				.orElseThrow(() -> new ClassNotFoundException(clazz + " no concrete class defined."));
	}
}
