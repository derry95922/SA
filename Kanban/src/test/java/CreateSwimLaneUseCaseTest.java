import org.junit.Test;

import static org.junit.Assert.*;

public class CreateSwimLaneUseCaseTest {
    @Test
    public void createSwimLaneInClass(){
        StageRepository stageRepository = new InMemoryStageRepository();
        String stageId = Utility.createStage(stageRepository, 1, "First Stage");
        String miniStageId = Utility.createMiniStage(stageId,stageRepository);
        MiniStage miniStage = stageRepository.findStage(stageId).getMiniStage(miniStageId);

        assertEquals(1, miniStage.getSwimLaneSize());

        CreateSwimLaneUseCase createSwimLaneUseCase = new CreateSwimLaneUseCase(stageRepository);
        CreateSwimLaneInput createSwimLaneInput = new CreateSwimLaneInput(stageId, miniStageId, "First SwimLane");
        CreateSwimLaneOutput createSwimLaneOutput = new CreateSwimLaneOutput();
        createSwimLaneUseCase.execute(createSwimLaneInput,createSwimLaneOutput);

        assertNotNull(createSwimLaneOutput.getSwimLaneId());
        assertEquals(2, miniStage.getSwimLaneSize());

        SwimLane swimLane = miniStage.getSwimLane(createSwimLaneOutput.getSwimLaneId());
        assertEquals(0, swimLane.getWIP());
    }
}