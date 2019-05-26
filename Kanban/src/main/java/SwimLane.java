import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SwimLane {
    private String miniStageId, name, swimLaneId;
    private List<SwimLane>swimLanes = new ArrayList<>();

    public SwimLane(String miniStageId, String name){
        this.miniStageId = miniStageId;
        this.name = name;
        this.swimLaneId  = UUID.randomUUID().toString();
    }

    public String getSwimLaneId() {
        return swimLaneId;
    }

    public String getSwimLaneName() {
        return name;
    }

    public int getSwimLanesSize() {
        return swimLanes.size();
    }
}
