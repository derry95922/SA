public class CreateStageInput {
    private int boardId;
    private String stageName;

    public CreateStageInput(int boardId, String stageName) {
        this.boardId = boardId;
        this.stageName = stageName;
    }

    public int getBoardId() {
        return boardId;
    }

    public String getStageName() {
        return stageName;
    }
}
