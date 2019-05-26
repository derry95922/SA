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

    public String getMiniStageName() {
        return name;
    }

    public int getSwimLaneSize() {
        return swimLanes.size();
    }

    public String getStageId() {
        return stageId;
    }

    public List<SwimLane> getSwimLaneList(){
        return swimLanes;
    }
}
