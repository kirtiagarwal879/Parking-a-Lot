package parkingalot.models;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String email;
    private String phone;
    public User(String name, String email, String phone) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    
    
}

