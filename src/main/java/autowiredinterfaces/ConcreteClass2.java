package autowiredinterfaces;

import org.springframework.stereotype.Component;

@Component
public class ConcreteClass2 implements Interface {

	@Override
	public void doSomething() {
		System.out.println("I am ConcreteClass2.");
	}

}
