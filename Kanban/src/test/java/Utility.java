public class Utility {
    //why static
    public static String createStage(StageRepository stageRepository, int boardId, String stageName) {
        CreateStageInput inputData1 = new CreateStageInput(boardId, stageName);
        CreateStageOutput outputData1 = new CreateStageOutput();

        CreateStageUseCase useCase = new CreateStageUseCase(stageRepository);
        useCase.execute(inputData1, outputData1);

        return outputData1.getStageId();
    }

    public static String createMiniStage(String stageId, StageRepository stageRepository) {
        CreateMiniStageUseCase createMiniStageUseCase = new CreateMiniStageUseCase(stageRepository);
        String miniStageName = "First MiniStage";
        CreateMiniStageInput createMiniStageInputData =
                new CreateMiniStageInput(stageId, miniStageName);
        CreateMiniStageOutput createMiniStageOutputData =
                new CreateMiniStageOutput();
        createMiniStageUseCase.execute(createMiniStageInputData ,createMiniStageOutputData);

        return createMiniStageOutputData.getMiniStageId();
    }
}
