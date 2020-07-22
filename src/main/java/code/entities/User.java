package code.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Table(name = "users", schema = "public")
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String userpic;
    private String email;
    private String gender;
    private String locale;
    @Column(name="last_visit")
    private LocalDateTime lastVisit;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocale() {
        return locale;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUserPic() {
        return userpic;
    }
    public void setUserPic(String userPic) {
        this.userpic = userPic;
    }

    public LocalDateTime getLastVisit() {
        return lastVisit;
    }
    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userpic='" + userpic + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", locale='" + locale + '\'' +
                ", lastVisit=" + lastVisit +
                '}';
    }
}