package sdf;

// import java.io.BufferedInputStream;
// import java.io.BufferedOutputStream;
// import java.io.DataInputStream;
// import java.io.DataOutputStream;
// import java.io.EOFException;
import java.io.File;
import java.io.IOException;
// import java.io.InputStream;
// import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws IOException {

        String dirPath = "data2";

        //instantiate a file/directory object
        File newDirectory = new File(dirPath);

        //if directory exists, print to console "directory exists" message
        //else create said directory
        if (newDirectory.exists()) {
            System.out.println("Directory already exists");
        } else {
            newDirectory.mkdir();
        }
        
        ServerSocket ss = new ServerSocket(1200);
        System.out.println("Starting server on port 1200, waiting incoming connection...\n");
        Socket s = ss.accept(); //establish connection, wait for client to connect
        System.out.println(("Connection established on localhost:1200\n"));

        Thread t = new Thread(new Cookie(s));
        t.start();
        ss.close();
    }
}
