import java.util.ArrayList;
import java.util.List;

public class InMemoryStageRepository implements StageRepository {
    private List<Stage> stageList = new ArrayList<>();

    @Override
    public void addStage(Stage stage) {
        stageList.add(stage);
    }

    @Override
    public Stage findStage(String stageId) {
        for(int i=0;i<stageList.size();i++){
            if(stageList.get(i).getStageId().equals(stageId))
                return stageList.get(i);
        }
        throw new RuntimeException("stage not found");
    }

    @Override
    public MiniStage findMiniStage(String miniStageId) {
        for(Stage i: stageList){
//        for(int i=0;i<stageList.size();i++){
            List<MiniStage> miniStageList = i.getMiniStageList();
            for(int j=0;j<miniStageList.size();j++){
                if(miniStageList.get(j).getMiniStageId().equals(miniStageId))
                    return miniStageList.get(j);
            }
        }
        throw new RuntimeException("miniStage not found");
    }

    @Override
    public SwimLane findSwimLane(String swimLaneId) {
        for(Stage stage:stageList){
            List<MiniStage>miniStageList = stage.getMiniStageList();
            for(MiniStage miniStage:miniStageList){
                List<SwimLane>swimLaneList = miniStage.getSwimLaneList();
                for(SwimLane swimLane:swimLaneList){
                    if(swimLane.getSwimLaneId().equals(swimLaneId))
                        return swimLane;
                }
            }
        }
        throw new RuntimeException("swim lane not found");
    }
}

