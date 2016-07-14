package example.helloworld;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;

public class HelloWorldJUnitTest extends JbpmJUnitBaseTestCase {

	@Test
	public void helloWorldTest() {
		KieSession ksession = createRuntimeManager("example/helloworld/HelloWorld.bpmn2").getRuntimeEngine(null)
				.getKieSession();

		ProcessInstance processInstance = ksession.startProcess("example.helloworld.HelloWorld");

		assertTrue(processInstance != null);
	}

}