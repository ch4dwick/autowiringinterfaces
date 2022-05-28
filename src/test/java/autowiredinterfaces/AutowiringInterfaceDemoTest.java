package autowiredinterfaces;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Comment out AutowiringInterfaceDemo.command
 */
@SpringBootTest
public class AutowiringInterfaceDemoTest {
	@Autowired	
	private InterfaceLoader loader;
	
	@Test
	public void testAllMethods() {
		loader.interfaces.forEach(i -> {
			assertThat(i).isInstanceOf(Interface.class);
			i.doSomething();
		});
	}
	
	@Test
	public void testInvalidMethod() {
		assertThrows(ClassNotFoundException.class, () -> loader.loadClass("idontexist"));
	}

}
