import org.junit.Test;

import static org.junit.Assert.*;

public class CreateMiniStageUseCaseTest {
    @Test
    public void createMiniStage(){
        StageRepository stageRepository = new InMemoryStageRepository();
        CreateStageUseCase createStageUC = new CreateStageUseCase(stageRepository);
        CreateStageInput createStageInput = new CreateStageInput(1, "first Stage");
        CreateStageOutput createStageOutput = new CreateStageOutput();
        createStageUC.execute(createStageInput,createStageOutput);

        CreateMiniStageUseCase  createMiniStageUC = new CreateMiniStageUseCase(stageRepository);
        CreateMiniStageInput createMiniStageInput = new CreateMiniStageInput(createStageOutput.getStageId(), "first MiniStage");
        CreateMiniStageOutput createMiniStageOutput = new CreateMiniStageOutput();
        createMiniStageUC.execute(createMiniStageInput, createMiniStageOutput);

        assertNotNull(createMiniStageOutput.getMiniStageId());
        assertEquals(2, stageRepository.findStage(createStageOutput.getStageId()).getMiniStageSize());

        MiniStage miniStage = stageRepository.findMiniStage(createMiniStageOutput.getMiniStageId());
        assertEquals(createMiniStageInput.getMiniStageName(), miniStage.getMiniStageName());
        assertEquals(1,miniStage.getSwimLaneSize());
    }
}