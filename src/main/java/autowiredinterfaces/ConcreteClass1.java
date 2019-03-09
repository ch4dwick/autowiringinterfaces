package autowiredinterfaces;

import org.springframework.stereotype.Component;

/**
 * Say for example you had one set of business rules to execute. Do them here. 
 * Take special note of the @Component annotation here. Spring won't include this in
 * the @Autowired collection without it.
 * 
 * @author Chad
 *
 */
@Component
public class ConcreteClass1 implements Interface {
	@Override
	public void doSomething() {
		System.out.println("I am ConcreteClass1.");
	}
}
