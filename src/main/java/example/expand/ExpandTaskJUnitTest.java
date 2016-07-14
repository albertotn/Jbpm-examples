package example.expand;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.kie.internal.utils.KieHelper;

public class ExpandTaskJUnitTest extends JbpmJUnitBaseTestCase {

	@Test
	public void expandTest() {
		//System.setProperty("org.jbpm.variable.strict", "true");
		
		KieHelper kieHelper = new KieHelper();

		KieBase kieBase = kieHelper
				.addResource(ResourceFactory.newClassPathResource("example/expandProcess/expand.bpmn2"))
				.addResource(ResourceFactory.newClassPathResource("example/expandProcess/subProcess.bpmn2")).build();		
		
		KieSession ksession = kieBase.newKieSession();
		WorkItemHandler wih = (WorkItemHandler) new ExpandWorkItem((StatefulKnowledgeSession) ksession);
		ksession.getWorkItemManager().registerWorkItemHandler("ExpandWorkItem",wih);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("variable1", "working");

		ProcessInstance processInstance = ksession.startProcess("expand.expand", params);

		assertTrue(processInstance != null);
	}

}