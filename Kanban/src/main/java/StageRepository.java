public interface StageRepository {
    void addStage(Stage stage);

    Stage findStage(String stageId);

    MiniStage findMiniStage(String miniStageId);

    SwimLane findSwimLane(String swimLaneId);
}
