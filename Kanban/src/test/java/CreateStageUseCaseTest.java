import org.junit.Test;

import static org.junit.Assert.*;

public class CreateStageUseCaseTest {

    @Test
    public void createTwoStage(){
        StageRepository stageRepository = new InMemoryStageRepository();
        CreateStageUseCase createStageUC = new CreateStageUseCase(stageRepository);

        CreateStageInput createStageInput1 = new CreateStageInput(1, "first stage");
        CreateStageOutput createStageOutput1 = new CreateStageOutput();
        CreateStageInput createStageInput2 = new CreateStageInput(1, "second stage");
        CreateStageOutput createStageOutput2 = new CreateStageOutput();
        createStageUC.execute(createStageInput1, createStageOutput1);
        createStageUC.execute(createStageInput2, createStageOutput2);
        //有創建成功
        assertNotNull(createStageOutput1.getStageId());
        assertNotNull(createStageOutput2.getStageId());
        //
        Stage stage1 = stageRepository.findStage(createStageOutput1.getStageId());
        Stage stage2 = stageRepository.findStage(createStageOutput2.getStageId());
        assertEquals(createStageInput1.getStageName(),stage1.getStageName());
        assertEquals(createStageInput2.getStageName(),stage2.getStageName());
        //policy for create stage
        assertEquals(1, stage1.getMiniStageSize());
        assertEquals(1, stage2.getMiniStageSize());
    }
}