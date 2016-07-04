package example.customDataMessage;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;

public class CustomDataMessageJUnitTest extends JbpmJUnitBaseTestCase {

	@Test
	public void customDataMessageTest() {
		KieSession ksession = createRuntimeManager("example/customDataMessage/CustomDataMessage.bpmn2")
				.getRuntimeEngine(null).getKieSession();

		ProcessInstance processInstance = ksession.startProcess("customDataMessage.CustomDataMessage");

		assertTrue(processInstance != null);
	}

}