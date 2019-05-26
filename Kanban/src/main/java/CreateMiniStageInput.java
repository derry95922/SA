public class CreateMiniStageInput {

    private String stageId;
    private String name;

    public CreateMiniStageInput(String stageId, String name){
        this.stageId = stageId;
        this.name = name;
    }

    public String getStageId() {
        return stageId;
    }

    public String getMiniStageName() {
        return name;
    }
}
