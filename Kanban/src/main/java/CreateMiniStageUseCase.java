public class CreateMiniStageUseCase {
    
    private StageRepository stageRepository;

    public CreateMiniStageUseCase(StageRepository repository){
        this.stageRepository = repository;
    }

    public void execute(CreateMiniStageInput createMiniStageInput, CreateMiniStageOutput createMiniStageOutput) {
        MiniStage miniStage = new MiniStage(createMiniStageInput.getStageId(), createMiniStageInput.getMiniStageName());
        Stage stage = stageRepository.findStage(createMiniStageInput.getStageId());
        stage.addMiniStage(miniStage);
        stageRepository.addStage(stage);
        createMiniStageOutput.setMiniStageId(miniStage.getMiniStageId());
    }
}
