package _01_Intro_To_Sockets.server;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class ServerGreeter extends Thread {
	// 1. Create an object of the ServerSocket class
	ServerSocket socket;

	public ServerGreeter() throws IOException {
		// 2. Initialize the ServerSocket object. In the parameters,
		// you must define the port at which the server will listen for connections.
		socket = new ServerSocket(8081);
		// *OPTIONAL* you can set a time limit for the server to wait by using the
		// ServerSocket's setSoTimeout(int timeInMilliSeconds) method
		socket.setSoTimeout(10000000);
	}

	public void run() {
		// 3. Create a boolean variable and initialize it to true.
		Boolean truth = new Boolean(true);
		// 4. Make a while loop that continues looping as long as the boolean created in
		// the previous step is true.
		while (truth == true) {

		
		// 5. Make a try-catch block that checks for two types Exceptions:
		// SocketTimeoutException and IOException.
		// Put steps 8 - 15 in the try block.
		try {

			// TODO: handle exception

			// 8. Let the user know that the server is waiting for a client to connect.
			JOptionPane.showConfirmDialog(null, "Waiting for client");
			// 9. Create an object of the Socket class and initialize it to
			// serverSocket.accept();
			// Change serverSocket to match the ServerSocket member variable you created in
			// step 1.
			// The program will wait her until either a client connects or the timeout
			// expires.
			Socket monkey = socket.accept();
			// 10. Let the user know that the client has connected.
			JOptionPane.showConfirmDialog(null, "User has connected");

			// 11. Create a DataInputStream object. When initializing it, use the Socket
			// object you created in step 9 to call the getInputStream() method.
			DataInputStream DPInput = new DataInputStream(monkey.getInputStream());

			// 12. Print the message from the DataInputStream object using the readUTF()
			// method
			DPInput.readUTF();

			// 13. Create a DataOutputStream object. When initializing it, use the Server
			// object you created in step 9 to call the getOutputStream() method.
			DataOutputStream DOStream = new DataOutputStream(monkey.getOutputStream());

			// 14. Use the DataOutputStream object to send a message to the client using the
			// writeUTF(String message) method.
			DOStream.writeUTF("message testing 2");

			// 15. Close the client server
			socket.close();
			// 6. If the program catches a SockeTimeoutException, let the user know about it
			// and set loop's boolean variable to false.
		} catch (SocketTimeoutException e) {
			truth = false;
			JOptionPane.showConfirmDialog(null, "SocketTimeoutException");
			// 7. If the program catches a IOException, let the user know about it and set
			// the loop's boolean variable to false.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			truth = false;
			JOptionPane.showConfirmDialog(null, "IOException");
		}

	}}

	public static void main(String[] args) {
		// 16. In a new thread, create an object of the ServerGreeter class and start
		// the thread. Don't forget the try-catch.
		try {
			Thread test = new ServerGreeter();
			test.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
