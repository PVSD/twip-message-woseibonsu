package com.company;
import java.util.Calendar;
import java.util.Date;

public class Message {

    private String message;
    private String sender;
    private String receipt;
    private Calendar calendar = Calendar.getInstance();
    int test = calendar.get(Calendar.DAY_OF_YEAR);

    public Message(String sender, String message)
    {
        this.message = message;
        this.sender = sender;
        this.receipt = "[" + calendar.getTime() + "]";
    }

    //INSTANCE RETRIEVERS
    public String getMessage() {return message;}
    public String getSender() {return sender;}
    public String getReceipt() {return receipt;}
    public Calendar getCalendar() {return calendar;}

}
