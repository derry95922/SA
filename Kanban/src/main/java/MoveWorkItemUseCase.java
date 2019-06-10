public class MoveWorkItemUseCase {

    StageRepository stageRepository;

    public MoveWorkItemUseCase(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public void execute(MoveWorkItemInput moveWorkItemInput, MoveWorkItemOutput moveWorkItemOutput) {
        Stage originalStage = stageRepository.findStage(moveWorkItemInput.getOriginalStageId());
        Stage destinationStage = stageRepository.findStage(moveWorkItemInput.getDestinationStageId());
        SwimLane originalSwimLane = originalStage.getSwimLaneById(moveWorkItemInput.getOriginalSwimLaneId());
        SwimLane destinationSwimLane = destinationStage.getSwimLaneById(moveWorkItemInput.getDestinationSwimLaneId());
        originalSwimLane.unCommitWorkItem(moveWorkItemInput.getWorkItemId());
        destinationSwimLane.commitWorkItem(moveWorkItemInput.getWorkItemId());
    }
}
