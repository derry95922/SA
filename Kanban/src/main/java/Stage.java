import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Stage {
    private int boardId;
    private String name;
    private String stageId;
    private List<MiniStage>miniStages = new ArrayList<>();

    public Stage(int boardId, String name){
        this.boardId = boardId;
        this.stageId = UUID.randomUUID().toString();
        this.name = name;
        addMiniStage(new MiniStage(stageId,"default mini stage"));
    }

    public void addMiniStage(MiniStage miniStage) {
        miniStages.add(miniStage);
    }

    public String getStageId() {
        return stageId;
    }

    public String getStageName() {
        return name;
    }

    public int getMiniStageSize() {
        return miniStages.size();
    }

    public List<MiniStage> getMiniStageList() {
        return miniStages;
    }
}
