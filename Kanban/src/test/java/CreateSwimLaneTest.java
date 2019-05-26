import org.junit.Test;

import static org.junit.Assert.*;

public class CreateSwimLaneTest {
    @Test
    public void createSwimLane(){
        StageRepository stageRepository = new InMemoryStageRepository();
        CreateStageUseCase createStageUC = new CreateStageUseCase(stageRepository);
        CreateStageInput createStageInput = new CreateStageInput(1, "first Stage");
        CreateStageOutput createStageOutput = new CreateStageOutput();
        createStageUC.execute(createStageInput,createStageOutput);

        CreateMiniStageUseCase  createMiniStageUC = new CreateMiniStageUseCase(stageRepository);
        CreateMiniStageInput createMiniStageInput = new CreateMiniStageInput(createStageOutput.getStageId(), "first MiniStage");
        CreateMiniStageOutput createMiniStageOutput = new CreateMiniStageOutput();
        createMiniStageUC.execute(createMiniStageInput, createMiniStageOutput);

        CreateSwimLaneUseCase createSwimLaneUC = new CreateSwimLaneUseCase(stageRepository);
        CreateSwimLaneInput createSwimLaneInput = new CreateSwimLaneInput(createMiniStageOutput.getMiniStageId(), "first swim lane");
        CreateSwimLaneOutput createSwimLaneOutput = new CreateSwimLaneOutput();
        createSwimLaneUC.execute(createSwimLaneInput, createSwimLaneOutput);

        assertNotNull(createSwimLaneOutput.getSwimLaneId());
        assertEquals(2, stageRepository.findMiniStage(createMiniStageOutput.getMiniStageId()).getSwimLaneSize());

        SwimLane swimLane = stageRepository.findSwimLane(createSwimLaneOutput.getSwimLaneId());
        assertEquals(createSwimLaneInput.getMiniStageName(), swimLane.getSwimLaneName());
    }
}