package daos;

public class User {
    private static int counter = 0;
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String city;

    public User(){

    }

    public User(String first_name, String last_name, String email, String gender, String city) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.city = city;

    }

    public User(Integer id, String first_name, String last_name, String email, String gender, String city) {
        this.id = ++counter;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.city = city;

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }


}
