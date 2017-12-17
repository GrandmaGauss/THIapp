package user;

import javafx.scene.image.Image;

public class UserBean {
    private String username;
    private String email;
    private String password;
    private String birthday;
    private String location;
    private String interests;
    private byte[] photo;
    private String filename;
    
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getBirthday() {
        return birthday;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }
    
    public void setInterests(String interests) {
        this.interests = interests;
    }
    public String getInterests() {
        return interests;
    }
    
    public void setPhoto (byte[] photo) {
        this.photo = photo;
    }
    public byte[] getPhoto () {
        return photo;
    }
    
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getFilename() {
        return filename;
    }
}

