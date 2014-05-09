package chat;
import java.io.*;
public class Message implements Serializable
{
	public boolean audience; //room=true, private=false
	public short roomNumber;
	public int recieverId;
	public int senderId;
	public String message;
}
