package examples.testWorkItem;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

/**
 * This is a sample file to launch a process.
 */
public class TestWorkItem implements WorkItemHandler {

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		manager.abortWorkItem(workItem.getId());
	}

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		System.out.println("Hello World");
		System.out.println(workItem.getParameter("param1"));
		manager.completeWorkItem(workItem.getId(), null);
	}

}