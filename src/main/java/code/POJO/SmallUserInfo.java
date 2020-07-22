package code.POJO;

import java.io.Serializable;

public class SmallUserInfo implements Serializable {
    private String name;
    private String userpic;

    public SmallUserInfo(String name, String userpic) {
        this.name = name;
        this.userpic = userpic;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUserpic() {
        return userpic;
    }
    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    @Override
    public String toString() {
        return "SmallUserInfo{" +
                "name='" + name + '\'' +
                ", userpic='" + userpic + '\'' +
                '}';
    }
}
