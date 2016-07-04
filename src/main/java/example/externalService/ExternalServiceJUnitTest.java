package example.externalService;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;

public class ExternalServiceJUnitTest extends JbpmJUnitBaseTestCase {

	@Test
	public void externalServiceTest() {
		KieSession ksession = createRuntimeManager("example/externalService/externalService.bpmn2")
				.getRuntimeEngine(null).getKieSession();

		ProcessInstance processInstance = ksession.startProcess("externalService.externalService");

		assertTrue(processInstance != null);
	}

}