public class CreateSwimLaneUseCase {
    private StageRepository stageRepository;
    public CreateSwimLaneUseCase(StageRepository stageRepository){
        this.stageRepository = stageRepository;
    }

    public void execute(CreateSwimLaneInput createSwimLaneInput, CreateSwimLaneOutput createSwimLaneOutput) {
//        SwimLane swimLane = new SwimLane(createSwimLaneInput.getMiniStageId(), createSwimLaneInput.getMiniStageName());
//        MiniStage miniStage = stageRepository.findMiniStage(createSwimLaneInput.getMiniStageId());
//        miniStage.addSwimLane(swimLane);
//        Stage stage = stageRepository.findStage(miniStage.getStageId());
//        stage.addMiniStage(miniStage);
//        stageRepository.addStage(stage);
        Stage stage = stageRepository.findStage(createSwimLaneInput.getStageId());
        MiniStage miniStage = stage.getMiniStage(createSwimLaneInput.getMiniStageId());
        SwimLane swimLane = new SwimLane(miniStage.getMinStageId(), createSwimLaneInput.getSwimLaneName());
        miniStage.addSwimLane(swimLane);
        createSwimLaneOutput.setSwimLaneId(swimLane.getSwimLaneId());
    }
}
