package domain;

/*
 * 用户的实体类JavaBean
 * */
public class User {
    private int id;
    private String username;
    private String password;

    private String gender;						//成员变量：gender
    public void setHehe(String gender) {		//属性：hehe
        this.gender = gender;
    }
    public String getHehe() {		//属性：hehe
        return gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
