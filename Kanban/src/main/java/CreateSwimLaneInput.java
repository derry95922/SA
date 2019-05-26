public class CreateSwimLaneInput {
    private String miniStageId, name;

    public CreateSwimLaneInput(String miniStageId, String name){
        this.miniStageId = miniStageId;
        this.name = name;
    }

    public String getMiniStageId() {
        return miniStageId;
    }

    public String getMiniStageName() {
        return name;
    }
}
