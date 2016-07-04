package example.twoProcess;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class TwoProcessJUnitTest extends JbpmJUnitBaseTestCase {

	@Test
	public void twoProcessTest() {

		KieHelper kieHelper = new KieHelper();

		KieBase kieBase = kieHelper
				.addResource(ResourceFactory.newClassPathResource("example/twoProcess/firstProcess.bpmn2"))
				.addResource(ResourceFactory.newClassPathResource("example/twoProcess/secondProcess.bpmn2")).build();

		KieSession ksession = kieBase.newKieSession();

		ProcessInstance processInstance = ksession.startProcess("twoprocess.firstProcess");

		assertTrue(processInstance != null);
	}

}