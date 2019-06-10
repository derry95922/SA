import org.junit.Test;

import static org.junit.Assert.*;

public class CreateStageUseCaseTest {

    @Test
    public void createStageInClass(){
        StageRepository stageRepository = new InMemoryStageRepository();
        String stageId1 = Utility.createStage(stageRepository, 1, "first stage");
        String stageId2 = Utility.createStage(stageRepository, 1, "second stage");

        assertNotNull(stageId1);
        assertNotNull(stageId2);

        Stage stage1 = stageRepository.findStage(stageId1);
        Stage stage2 = stageRepository.findStage(stageId2);

        assertEquals("first stage", stage1.getStageName());
        assertEquals("second stage", stage2.getStageName());
        assertEquals(1, stage1.getMiniStageSize());
        assertEquals(1, stage2.getMiniStageSize());
    }
}