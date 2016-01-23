package com.rm5248.rmiclient;

import com.rm5248.rmiinterfaces.PrintingInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Main class for a client.
 * 
 * Set the following properties on the command line:
 * 
 * <br>
 * -Djava.rmi.server.useCodebaseOnly=false
 * <br>
 * -Djava.rmi.server.codebase=file:/path/to/compiled/classes/
 * <br>
 * -Djava.security.policy=client.policy
 * <br>
 * 
 * <b>NOTE: MAKE SURE YOU HAVE THE TRAILING / ON THE CODEBASE PATH</b>
 */
public class RMIClientMain {

    public static void main(String[] args) {
        // Set the Security Manager that we want to use.
        // The Security Manager must be set, or it will not work.
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        try {
            String name = "RMI-EchoMessage";
            Registry registry = LocateRegistry.getRegistry("localhost");
            PrintingInterface comp = (PrintingInterface) registry.lookup(name);
            
            System.out.println("About to try to print!");
            
            String messageToEcho = "Hi from the client!";
            if( args.length > 0 ){
                messageToEcho = args[ 0 ];
            }
            int returnVal = comp.echoMessage( messageToEcho );
            
            System.out.println( "The return value from the server is: " + returnVal );
        } catch (Exception e) {
            System.err.println( "Exception while trying to echo:" );
            e.printStackTrace();
        }
    }
}
