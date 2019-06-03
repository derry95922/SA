import java.util.ArrayList;
import java.util.List;

public class InMemoryWorkItemRepository implements WorkItemRepository {
    private List<WorkItem>workItems = new ArrayList<>();

    @Override
    public WorkItem findWorkItem(String workItemId) {
        for(WorkItem workItem:workItems){
            if(workItem.getId().equals(workItemId))
                return workItem;
        }
        throw  new RuntimeException("workItem not found");
    }

    @Override
    public void addWorkItem(WorkItem workItem) {
        workItems.add(workItem);
    }
}
