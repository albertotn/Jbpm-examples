package example.helloworld;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class HelloWorldJUnitTest extends JbpmJUnitBaseTestCase {

	@Test
	public void testImplicit() {
		KieHelper kieHelper = new KieHelper();
		KieBase kieBase = kieHelper.addResource(ResourceFactory.newClassPathResource("HelloWorld.bpmn2")).build();

		KieSession ksession = kieBase.newKieSession();

		ProcessInstance processInstance = ksession.startProcess("example.helloworld.HelloWorld");
		// do your checks here
		// for example, assertProcessInstanceCompleted(processInstance.getId(),
		// ksession);
		System.out.println("id: " + processInstance.getId());
		System.out.println("parent id: " + processInstance.getParentProcessInstanceId());

	}

}