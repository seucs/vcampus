package Message;

import java.io.Serializable;

public class BookMessage implements Serializable {
    private String code;
    private String bookname;
    private String address;
    private String author;
    private String press;
    private int total;
    private int keep;
    private int ordered;
    private int borrowed;
    private int available;
    private String comment;
    
    public void setCode(String code)
    {
        this.code = code;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public void setBookname(String bookname)
    {
        this.bookname = bookname;
    }
    
    public String getBookname()
    {
        return bookname;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public void setPress(String press)
    {
        this.press = press;
    }
    
    public String getPress()
    {
        return press;
    }
    
    public void setTotal(int total)
    {
        this.total = total;
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void setKeep(int keep)
    {
        this.keep = keep;
    }
    
    public int getKeep()
    {
        return keep;
    }
    
    public void setOrdered(int ordered)
    {
        this.ordered = ordered;
    }
    
    public int getOrdered()
    {
        return ordered;
    }
    
    public void setBorrowed(int borrowed)
    {
        this.borrowed = borrowed;
    }
    
    public int getBorrowed()
    {
        return borrowed;
    }
    
    public void setAvailable(int available)
    {
        this.available = available;
    }
    
    public int getAvailable()
    {
        return available;
    }
    
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    public String getComment()
    {
        return comment;
    }
}