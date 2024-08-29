public interface ManagementInterface <T>{
    void create(T ObjectName);
    void read(int id);
    void update(int id, String values);
    void delete(int id);
}