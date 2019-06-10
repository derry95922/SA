public class MoveWorkItemInput {
    private String originalStageId, originalSwimLaneId, destinationStageId, destinationSwimLaneId, workItemId;

    public MoveWorkItemInput(String originalStageId, String originalSwimLaneId, String destinationStageId, String destinationSwimLaneId, String workItemId) {
        this.originalStageId = originalStageId;
        this.originalSwimLaneId = originalSwimLaneId;
        this.destinationStageId = destinationStageId;
        this.destinationSwimLaneId = destinationSwimLaneId;
        this.workItemId = workItemId;
    }

    public String getOriginalStageId() {
        return originalStageId;
    }

    public String getDestinationStageId() {
        return destinationStageId;
    }

    public String getWorkItemId() {
        return workItemId;
    }

    public String getOriginalSwimLaneId() {
        return originalSwimLaneId;
    }

    public String getDestinationSwimLaneId() {
        return destinationSwimLaneId;
    }
}
