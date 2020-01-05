package _02_Chat_Application;

import java.net.*;
import java.io.*;

public class ClientG {
private String ipStr;
private int port;

Socket sock;

DataOutputStream opStream;
DataInputStream dpStream;
	public ClientG(String ipStr, int port) {
		// TODO Auto-generated constructor stub
		this.ipStr = ipStr;
		this.port = port;
	}

	public void start() {
		// 1. Create a String for the ip address of the server.
		// If you don't know how to find a computer's ip address, ask about ifconfig on
		// linux/mac and ipconfig on windows.
		
		// 2. Create an integer for the server's port number
		
		// 3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.

		try {
			// 4. Create an object of the Socket class. When initializing the object, pass
			// in the ip address and the port number
			Socket sock = new Socket(ipStr, port);
			
			// 5. Create a DataOutputStream object. When initializing it, use the Socket
			// object you created in step 4 to call the getOutputStream() method.
			opStream = new DataOutputStream(sock.getOutputStream());
			
			// 6. Use the DataOutputStream object to send a message to the server using the
			// writeUTF(String message) method
			
			// 7. Create a DataInputStream object. When initializing it, use the Server
			// object you created in step 4 to call the getInputStream() method.
			DataInputStream dpStream = new DataInputStream(sock.getInputStream());
		}catch (IOException e) {
				// TODO: handle exception
			}
	}
	
	public void sendMessage() {
			try {
			// 8. Use the DataInputStream object to print a message from the server using
			// the readUTF() method.
			opStream.writeUTF("Message test");
			dpStream.readUTF();
			
			// 9. Close the client's server object
			sock.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();



		}
		
	}

	
	

}