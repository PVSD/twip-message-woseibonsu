package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MessageList
{
    private List<Message> messagesLog = new ArrayList<>();
    private String convoName;

    public MessageList (String person)
    {
        this.convoName = person;
    }

    public String showChatLog() {
        StringBuilder chatHistory = new StringBuilder();

        for(Message temp : messagesLog)
        {
            chatHistory.append(temp.getReceipt());
            chatHistory.append(" ");
            chatHistory.append(temp.getSender());
            chatHistory.append(": ");
            chatHistory.append(temp.getMessage());
            chatHistory.append("\n");
        }
        return chatHistory.toString();
    }
    public void deleteMessage(int number){messagesLog.remove(number - 1);}
    public void addMessage(Message message){messagesLog.add(message);}
    public void merge(MessageList a) {
        messagesLog.addAll(a.getMessagesLog());
        Collections.sort(messagesLog, new sortByTime());
    }

    private List<Message> getMessagesLog() {
        return messagesLog;
    }
    public String getConvoName() {
        return convoName;
    }
}

class sortByTime implements Comparator<Message> {
    public int compare(Message a, Message b)
    {
        if(a.getCalendar().getTime().getTime() > b.getCalendar().getTime().getTime())
        {
            return 1;
        }
        else if (a.getCalendar().getTime().getTime() < b.getCalendar().getTime().getTime())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
