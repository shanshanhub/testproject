package ehcache;

/**
 * @author WanChuanLai
 * @create 1/10/17.
 */
public class User {
    public User(String userName) {
        this.userName = userName;
    }

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
