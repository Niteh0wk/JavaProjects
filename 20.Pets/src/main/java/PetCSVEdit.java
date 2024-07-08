import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class PetCSVEdit {
    private final String filepath;
    HashMap<Integer, Pet> pets;

    public PetCSVEdit(){
        filepath = "pets.csv";
        pets = new HashMap<>();
    }

    public void createPet(String name, int id, int person_id) throws IOException {
        FileWriter writer = new FileWriter(filepath);
        char[] content = (name + ", " + id + ", " + person_id).toCharArray();
        writer.write(content);
        writer.close();
        Pet currentPet = new Pet(name, id, person_id);
        pets.put(id, currentPet);
    }

    public Pet getPetWithName(String name) {
        for (Pet pet : pets.values()){
            if (pet.getName().equalsIgnoreCase(name)){
                return pet;
            }
        }
        return null;
    }

    public Pet getPetWithId(int id){
        return pets.get(id);
    }
}
