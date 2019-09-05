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
    public User(String id,String name,String password ,String email){
        this(id,password);
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
