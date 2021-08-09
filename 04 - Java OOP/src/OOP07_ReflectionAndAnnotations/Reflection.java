package OOP07_ReflectionAndAnnotations;

import java.io.Serializable;

public class Reflection implements Serializable {

    private static final String NICKNAME = "Penguin";
    public String name;
    protected  String webAddress;
    String email;
    private int zip;

    public Reflection() {
        this.setName("Java");
    }

    public static String getNICKNAME() {
        return NICKNAME;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
