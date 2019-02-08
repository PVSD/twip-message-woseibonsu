package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kbinput = new Scanner(System.in);
        List<MessageList> convos = new ArrayList<>();
        String input;

        System.out.println("Instant Messenger" +
                "\n  COMMANDS:" +
                "\n\tNEW CONVERSATION: New Convo InsertName" +
                "\n\tSEND MESSAGE: Send MSG InsertName" +
                "\n\tDELETE CONVERSATION: Delete Convo InsertName" +
                "\n\tMERGE CONVERSATION: Merge Convo InsertNameOne and InsertNameTwo" +
                "\n\tEXIT: Exit");

        boolean on = true;
        boolean sendingMessages = true;

        while(on)
        {
            input = kbinput.nextLine();

            //NEW CONVERSATION COMMAND
            if(input.trim().toLowerCase().contains("new convo"))
            {

                convos.add(new MessageList(input.substring(input.trim().lastIndexOf(" ") + 1, input.trim().length())));
                System.out.println("Made new conversation with " + input.substring(input.trim().lastIndexOf(" ") + 1, input.trim().length()));
            }

            //ENTER CONVERSATION COMMAND
            else if(input.trim().toLowerCase().contains("send msg"))
            {
                int count = 0;


                while (true)
                {
                    outerloop:
                    for (MessageList temp : convos)
                    {
                        if(temp.getConvoName().equalsIgnoreCase(
                                input.substring(input.trim().lastIndexOf(" ") + 1, input.trim().length())))
                        {
                            //NEW COMMANDS WHEN INSIDE THE CONVERSATION
                            System.out.println(("  COMMANDS:" +
                                    "\n\tSEND MESSAGE: Send MSG " +
                                    "\n\tDELETE MESSAGE: Delete MSG" +
                                    "\n\tEXIT: Exit"));

                            input = kbinput.nextLine();

                            //SEND A MESSAGE COMMAND
                            if (input.trim().equalsIgnoreCase("Send MSG"))
                            {
                                while (true) {
                                    System.out.println("Who is sending this message: ");
                                    String sender = kbinput.nextLine();
                                    System.out.println("What is the message: ");
                                    String message = kbinput.nextLine();
                                    convos.get(count).addMessage(new Message(sender, message));
                                    System.out.println(convos.get(count).showChatLog());
                                    System.out.println("Would you like to send another message? (YES or NO)");
                                    input = kbinput.nextLine();
                                    if (input.equalsIgnoreCase("YES"))
                                    {

                                    }
                                    else if (input.equalsIgnoreCase("NO"))
                                    {
                                        count = 0;
                                        break outerloop;
                                    }
                                }
                            }

                            if (input.trim().equalsIgnoreCase("Delete MSG"))
                            {
                                System.out.println(convos.get(count).showChatLog());
                                System.out.println("Select a message to delete");
                                input = kbinput.next();
                                convos.get(count).deleteMessage(Integer.parseInt(input));
                            }

                        }
                        else
                        {
                            count ++;
                        }
                    }
                }


            }

            //CONVERSATION MERGE COMMAND
            else if(input.trim().toLowerCase().contains("MergeConvo"))
            {

            }

            //DELETE CONVERSATION COMMAND
            else if(input.trim().toLowerCase().contains("Delete Convo"))
            {
                int count = 0;
                for (MessageList temp : convos)
                {
                    if(temp.getConvoName().equalsIgnoreCase(
                            input.substring(input.trim().lastIndexOf(" "), input.trim().length())))
                    {
                        convos.remove(count);
                    }
                    count ++;
                }
            }

            //EXIT COMMAND
            else if(input.trim().equalsIgnoreCase("Exit"))
            {
                break;
            }
        }
    }
}
