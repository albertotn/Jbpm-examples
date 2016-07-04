package example.createInstances;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;

public class CreateInstancesJUnitTest extends JbpmJUnitBaseTestCase {

	@Test
	public void createInstanceTest() {
		KieSession ksession = createRuntimeManager("example/createInstances/CreateInstances.bpmn2")
				.getRuntimeEngine(null).getKieSession();
		ProcessInstance processInstance = ksession.startProcess("example.createInstances.CreateInstances");
		assertTrue(processInstance != null);

		// create new instances for given process definition
		for (int i = 0; i < 10; i++) {
			ProcessInstance another = ksession.createProcessInstance(processInstance.getProcessId(), null);
			ksession.startProcessInstance(another.getId());
		}
	}

}