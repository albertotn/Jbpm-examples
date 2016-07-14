package example.expand;

import org.jbpm.process.workitem.AbstractWorkItemHandler;
import org.jbpm.ruleflow.instance.RuleFlowProcessInstance;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.internal.runtime.StatefulKnowledgeSession;

/**
 * Example how to manipulate a proceses instance adding a task at runtime
 */
public class ExpandWorkItem extends AbstractWorkItemHandler {

	private ProcessInstance subProcess;

	public ExpandWorkItem(StatefulKnowledgeSession ksession) {
		super(ksession);
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		manager.abortWorkItem(workItem.getId());
	}

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		long pid = workItem.getProcessInstanceId();
		System.out.println("pid=" + pid);
		if (subProcess == null) {
			subProcess = getSession().startProcess("subProcess.subProcess");
			if (subProcess.getState() == ProcessInstance.STATE_COMPLETED) {
				manager.completeWorkItem(workItem.getId(), null);
			}

		} else {
			RuleFlowProcessInstance instance = (RuleFlowProcessInstance) getSession()
					.getProcessInstance(subProcess.getId());
			if (instance.getState() == ProcessInstance.STATE_COMPLETED) {
				manager.completeWorkItem(workItem.getId(), null);
			}
		}
	}

}