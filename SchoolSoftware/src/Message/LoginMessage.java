package Message;

import java.io.Serializable;

public class LoginMessage implements Serializable{

    private String name;
    private String onecard;
    private String studentnumber;
    private String password;
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setOnecard(String onecard)
    {
        this.onecard = onecard;
    }
    
    public String getOnecard()
    {
        return onecard;
    }
    
    public void setStudentnumber(String studentnumber)
    {
        this.studentnumber = studentnumber;
    }
    
    public String getStudentnumber()
    {
        return studentnumber;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    
}