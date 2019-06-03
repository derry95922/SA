public class CreateWorkItemUseCase {
    private WorkItemRepository workItemRepository;

    public CreateWorkItemUseCase(WorkItemRepository workItemRepository) {
        this.workItemRepository = workItemRepository;
    }

    public void execute(CreateWorkItemInput createWorkItemInput, CreateWorkItemOutput createWorkItemOutput) {
        WorkItem workItem = new WorkItem(createWorkItemInput.getName());
        workItemRepository.addWorkItem(workItem);
        createWorkItemOutput.setWorkItemId(workItem.getId());
    }
}
