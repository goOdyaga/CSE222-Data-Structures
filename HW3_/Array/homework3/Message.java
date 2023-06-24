package homework3;




/**
 * This class represent for send or get message from a account 
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
public class Message {

    private int Mesage_id;
    private String ReceiverName;
    private String SenderName;
    private String Content;

    /**
     * constrcter of message
     * @param RECEİVER receiver message
     * @param Sender sender of message
     * @param content content of message
     * @param ID_message ıd of message
     */
    public Message(String RECEIVER,String Sender,String content,int ID_message)
    {
        Mesage_id=ID_message;
        ReceiverName=new String(RECEIVER);
        SenderName=new String(Sender);
        Content=new String(content);

    }
    /**
     * This function represent for  return content os message
     * @return content of message
     */
    public String getContent()
    {
        return Content;
    }
    
    /**
     * This function represent for 
     * @return Id ofmessage 
     */
    public int getMesage_id() 
    {
        return Mesage_id;
    }

    /**
     * This function represent for return sender name
     * @return Sender name of the message
     */
    public String getSenderName() 
    {
        return SenderName;
    }

    /**
     * This function represent for return receiver name
     * @return receiver name of the messages
     */
    public String getReceiverName() 
    {
        return ReceiverName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Message other = (Message) obj;
        if (Mesage_id != other.Mesage_id)
            return false;
        if (ReceiverName == null) {
            if (other.ReceiverName != null)
                return false;
        } else if (!ReceiverName.equals(other.ReceiverName))
            return false;
        if (SenderName == null) {
            if (other.SenderName != null)
                return false;
        } else if (!SenderName.equals(other.SenderName))
            return false;
        if (Content == null) {
            if (other.Content != null)
                return false;
        } else if (!Content.equals(other.Content))
            return false;
        return true;
    }
}
