package example.signalProceses;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;

public class SignalProcesesJUnitTest extends JbpmJUnitBaseTestCase {

	@Test
	public void helloWorld() {
		KieSession ksession = createRuntimeManager("example/signalProcess/signalProcess.bpmn2").getRuntimeEngine(null)
				.getKieSession();

		ProcessInstance processInstance = ksession.startProcess("signalProcess.signalProcess");

		// processInstance.signalEvent("Signal 1", "Signal 1");

		assertTrue(processInstance != null);
	}

}