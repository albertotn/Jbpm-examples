package example.dataMessage;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;

public class DataMessageJUnitTest extends JbpmJUnitBaseTestCase {

	@Test
	public void dataMessageTest() {
		KieSession ksession = createRuntimeManager("example/dataMessage/dataMessage.bpmn2").getRuntimeEngine(null)
				.getKieSession();

		ProcessInstance processInstance = ksession.startProcess("dataMessage.dataMessage");

		assertTrue(processInstance != null);
	}

}