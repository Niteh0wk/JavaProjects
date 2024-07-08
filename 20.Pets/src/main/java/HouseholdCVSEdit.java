import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class HouseholdCVSEdit {
    private final String filepath;
    HashMap<Integer, Household> households;
    PersonCVSEdit personCVSEdit;

    public HouseholdCVSEdit(){
        filepath = "households.csv";
        households = new HashMap<>();
    }

    public void createHousehold(String name, int id) throws IOException {
        FileWriter writer = new FileWriter(filepath);
        char[] content = (name + ", " +  id).toCharArray();
        writer.write(content);
        writer.close();
        Household currentHousehold = new Household(name, id);
        households.put(id, currentHousehold);
    }

    public Household getHouseholdWithName(String name){
        for (Household household : households.values()){
            if (household.getName().equalsIgnoreCase(name)){
                return household;
            }
        }
        return null;
    }

    public Household getHouseholdWithId(int id){
        return households.get(id);
    }
}
