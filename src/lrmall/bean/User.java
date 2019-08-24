package lrmall.bean;

public class User {
    private String id;
    private String name;
    private String password;
    private String email;
    private String address;

    public User(){}
    
    public User(String id,String password){
        this.id = id;
        this.password = password;
    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getId(){
        return id;
    }

    public String getAddress() {
        return address;
    }
}
