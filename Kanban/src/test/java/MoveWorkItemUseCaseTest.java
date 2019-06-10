import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveWorkItemUseCaseTest {

    private String backlogId;
    private StageRepository stageRepository;
    private WorkItemRepository workItemRepository;
    private String workItemId;
    private Stage backlog;
    private Stage analysis;

    @Before
    public void setUp(){
        workItemRepository = new InMemoryWorkItemRepository();

        CreateWorkItemUseCase createWorkItemUseCase = new CreateWorkItemUseCase(workItemRepository);
        CreateWorkItemInput createWorkItemInput = new CreateWorkItemInput("first work item");
        CreateWorkItemOutput createWorkItemOutput = new CreateWorkItemOutput();
        createWorkItemUseCase.execute(createWorkItemInput,createWorkItemOutput);

        workItemId = createWorkItemOutput.getWorkItemId();
        stageRepository = new InMemoryStageRepository();
        backlogId = Utility.createStage(stageRepository,1,"Backlog");
        backlog = stageRepository.findStage(backlogId);
        String analysisId = Utility.createStage(stageRepository,1,"Analysis");
        analysis = stageRepository.findStage(analysisId);
        assertEquals(0, backlog.getDefaultSwimLane().getCommittedWorkItems().size());

        CommitWorkItemUseCase commitWorkItemUseCase = new CommitWorkItemUseCase(stageRepository);
        CommitWorkItemInput commitWorkItemInput = new CommitWorkItemInput(backlogId, backlog.getDefaultSwimLane().getSwimLaneId(), createWorkItemOutput.getWorkItemId());
        CommitWorkItemOutput commitWorkItemOutput = new CommitWorkItemOutput();
        commitWorkItemUseCase.execute(commitWorkItemInput,commitWorkItemOutput);

        assertEquals(1,backlog.getDefaultSwimLane().getCommittedWorkItems().size());
    }

    @Test
    public void moveWorkItemUseCase(){
        MoveWorkItemUseCase moveWorkItemUseCase = new MoveWorkItemUseCase(stageRepository);
        MoveWorkItemInput moveWorkItemInput = new MoveWorkItemInput(backlog.getStageId(),
                backlog.getDefaultSwimLane().getSwimLaneId(),
                analysis.getStageId(),
                analysis.getDefaultSwimLane().getSwimLaneId(),
                workItemId);
        MoveWorkItemOutput moveWorkItemOutput = new MoveWorkItemOutput();
        moveWorkItemUseCase.execute(moveWorkItemInput,moveWorkItemOutput);

        assertEquals(0,backlog.getDefaultSwimLane().getCommittedWorkItems().size());
        assertEquals(1, analysis.getDefaultSwimLane().getCommittedWorkItems().size());
    }
}