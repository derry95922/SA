import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class SwimLane {
    private String miniStageId, name, swimLaneId;
    private int wip = 0;
    private List<String> workItemIds;

    public SwimLane(String miniStageId, String name){
        this.miniStageId = miniStageId;
        this.name = name;
        this.swimLaneId  = UUID.randomUUID().toString();
        this.workItemIds = new ArrayList<>();
    }

    public String getSwimLaneId() {
        return swimLaneId;
    }

    public int getWIP() {
        return this.wip;
    }

    public List<String> getCommittedWorkItems() {
        return workItemIds;
    }

    public void commitWorkItem(String workItemId) {
        workItemIds.add(workItemId);
    }

    public void unCommitWorkItem(String workItemId) {
        workItemIds.remove(workItemId);
    }
}
