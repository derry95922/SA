public class CreateStageUseCase {
    private StageRepository stageRepository;

    public CreateStageUseCase(StageRepository repository){
        this.stageRepository = repository;
    }

    public void execute(CreateStageInput createStageInput, CreateStageOutput createStageOutput) {
        Stage stage = new Stage(createStageInput.getBoardId(), createStageInput.getStageName());
        stageRepository.addStage(stage);
        createStageOutput.setStageId(stage.getStageId());
    }
}
