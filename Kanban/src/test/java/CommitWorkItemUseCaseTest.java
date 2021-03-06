import org.junit.Test;

import static org.junit.Assert.*;

public class CommitWorkItemUseCaseTest {
    @Test
    public void commitWorkItemTest(){
        WorkItemRepository workItemRepository = new InMemoryWorkItemRepository();

        String workItemId = Utility.createWorkItem(workItemRepository, "first work item");

        StageRepository stageRepository = new InMemoryStageRepository();
        String stageId = Utility.createStage(stageRepository, 0 , "Backlog");
        Stage backlog = stageRepository.findStage(stageId);
        assertEquals(0, backlog.getDefaultSwimLane().getCommittedWorkItems().size());

        CommitWorkItemUseCase commitWorkItemUseCase = new CommitWorkItemUseCase(stageRepository);
        CommitWorkItemInput commitWorkItemInput = new CommitWorkItemInput(stageId, backlog.getDefaultSwimLane().getSwimLaneId(), workItemId);
        CommitWorkItemOutput commitWorkItemOutput = new CommitWorkItemOutput();
        commitWorkItemUseCase.execute(commitWorkItemInput,commitWorkItemOutput);

        assertEquals(1,backlog.getDefaultSwimLane().getCommittedWorkItems().size());
    }
}