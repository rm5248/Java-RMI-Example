package com.rm5248.rmiserver;

import com.rm5248.rmiinterfaces.PrintingInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple implementation of an RMI server.
 * 
 * Set the following properties on the command line:
 * <br>
 * -Djava.rmi.server.useCodebaseOnly=false
 * <br>
 * -Djava.rmi.server.codebase=file:/path/to/compiled/class/files/
 * <br>
 * 
 * <b>NOTE: MAKE SURE YOU HAVE THE TRAILING / ON THE CODEBASE PATH</b>
 *
 */
public class RMIServerMain {

    public static void main(String[] args) {
        // First, create the real object which will do the requested function.
        PrintingInterfaceImpl implementation = new PrintingInterfaceImpl();

        try {
            // Export the object.
            PrintingInterface stub = (PrintingInterface) UnicastRemoteObject.exportObject(implementation, 0);
            Registry registry = LocateRegistry.getRegistry();
            // I don't know why we have to rebind at all.
            // However, this does set the string that you need to use in order to lookup the remote class.
            registry.rebind("RMI-EchoMessage", stub);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return;
        }
        System.out.println( "Bound!" );
        System.out.println( "Server will wait forever for messages." );
    }
}
