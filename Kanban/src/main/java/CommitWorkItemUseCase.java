public class CommitWorkItemUseCase {
    StageRepository stageRepository;

    public CommitWorkItemUseCase(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public void execute(CommitWorkItemInput commitWorkItemInput, CommitWorkItemOutput commitWorkItemOutput) {
        Stage stage = stageRepository.findStage(commitWorkItemInput.getStageId());
        SwimLane swimLane = stage.getSwimLaneById(commitWorkItemInput.getSwimLaneId());
        swimLane.commitWorkItem(commitWorkItemInput.getWorkItemId());
        stageRepository.update(stage);
    }
}
