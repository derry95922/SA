import org.junit.Test;

import static org.junit.Assert.*;

public class CreateStageUseCaseTest {

    @Test
    public void createStageInClass(){
        StageRepository stageRepository = new InMemoryStageRepository();

        String stageId = Utility.createStage(stageRepository, 1, "first stage");
        assertNotNull(stageId);
        Stage stage = stageRepository.findStage(stageId);
        assertEquals(1, stage.getMiniStageSize());

        String miniStageId = Utility.createMiniStage(stageId,stageRepository);
        assertNotNull(miniStageId);
        assertEquals(2, stage.getMiniStageSize());

        MiniStage miniStage = stage.getMiniStage(miniStageId);
        assertEquals(1, miniStage.getSwimLaneSize());
    }
}