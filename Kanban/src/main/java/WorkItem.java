import java.util.UUID;

public class WorkItem {
    private String name, id;

    public WorkItem(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
