import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MiniStage {
    private String stageId;
    private String miniStageId;
    private String name;
    private List<SwimLane>swimLanes = new ArrayList<>();

    public MiniStage(String stageId, String miniStageName) {
        this.miniStageId = UUID.randomUUID().toString();
        this.stageId = stageId;
        this.name = miniStageName;
        addSwimLane(new SwimLane(miniStageId,"default swim lane"));
    }

    public void addSwimLane(SwimLane swimLane) {
        swimLanes.add(swimLane);
    }

    public String getMiniStageId() {
        return miniStageId;
    }

    public int getSwimLaneSize() {
        return swimLanes.size();
    }

    public String getStageId() {
        return stageId;
    }

    public String getMinStageId() {
        return miniStageId;
    }

    public SwimLane getSwimLane(String swimLaneId) {
        for(int i=0;i<swimLanes.size();i++){
            if(swimLanes.get(i).getSwimLaneId().equals(swimLaneId))
                return swimLanes.get(i);
        }
        throw new RuntimeException("Swim Lane not found");
    }
}
