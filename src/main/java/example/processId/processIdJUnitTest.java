package example.processId;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;

public class processIdJUnitTest extends JbpmJUnitBaseTestCase {

	@Test
	public void processIdTest() {
		KieSession ksession = createRuntimeManager("example/processId/processId.bpmn2").getRuntimeEngine(null)
				.getKieSession();
		ProcessInstance processInstance = ksession.startProcess("example.processId.processId");

		assertTrue(processInstance != null);
	}

}