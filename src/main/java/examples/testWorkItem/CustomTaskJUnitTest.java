package examples.testWorkItem;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkItemHandler;

public class CustomTaskJUnitTest extends JbpmJUnitBaseTestCase {

	@Test
	public void helloWorldTest() {
		System.setProperty("org.jbpm.variable.strict", "true");
		KieSession ksession = createRuntimeManager("example/testWorkItem/testWorkItem.bpmn2")
				.getRuntimeEngine(null).getKieSession();
		
		ksession.getWorkItemManager().registerWorkItemHandler("TestWorkItem",
				(WorkItemHandler) new TestWorkItem());
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("variable1", "working");

		ProcessInstance processInstance = ksession.startProcess("testWorkItem.testWorkItem", params);

		assertTrue(processInstance != null);
	}

}