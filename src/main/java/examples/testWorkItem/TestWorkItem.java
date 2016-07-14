package examples.testWorkItem;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

/**
 * A simple WorkItemHandler implementation
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