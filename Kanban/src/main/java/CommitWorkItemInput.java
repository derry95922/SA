public class CommitWorkItemInput {
    String stageId, swimLaneId, workItemId;

    public CommitWorkItemInput(String stageId, String swimLaneId, String workItemId) {
        this.stageId = stageId;
        this.swimLaneId = swimLaneId;
        this.workItemId = workItemId;
    }

    public String getStageId() {
        return stageId;
    }

    public String getSwimLaneId() {
        return swimLaneId;
    }

    public String getWorkItemId() {
        return workItemId;
    }
}
