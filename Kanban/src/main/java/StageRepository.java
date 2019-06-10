public interface StageRepository {
    void addStage(Stage stage);

    Stage findStage(String stageId);

    void update(Stage stage);
}
