public class CreateSwimLaneInput {
    private String miniStageId, name, stageId;

    public CreateSwimLaneInput(String stageId, String miniStageId, String name){
        this.miniStageId = miniStageId;
        this.name = name;
        this.stageId = stageId;
    }

    public String getMiniStageId() {
        return miniStageId;
    }

    public String getStageId(){
        return stageId;
    }

    public String getSwimLaneName() {
        return name;
    }
}
