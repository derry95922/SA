import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateWorkItemUseCaseTest {

    @Test
    public void CreateWorkItemUseCaseTest(){
        WorkItemRepository workItemRepository = new InMemoryWorkItemRepository();

        CreateWorkItemUseCase createWorkItemUseCase = new CreateWorkItemUseCase(workItemRepository);
        CreateWorkItemInput createWorkItemInput = new CreateWorkItemInput("First Work Item");
        CreateWorkItemOutput createWorkItemOutput = new CreateWorkItemOutput();
        createWorkItemUseCase.execute(createWorkItemInput,createWorkItemOutput);

        WorkItem workItem = workItemRepository.findWorkItem(createWorkItemOutput.getWorkItemId());
        assertEquals("First Work Item", workItem.getName());
    }
}