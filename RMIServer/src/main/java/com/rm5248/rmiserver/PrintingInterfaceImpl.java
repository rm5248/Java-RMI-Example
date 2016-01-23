package com.rm5248.rmiserver;

import com.rm5248.rmiinterfaces.PrintingInterface;
import java.rmi.RemoteException;

/**
 * A simple implementation of a printing interface.
 */
public class PrintingInterfaceImpl implements PrintingInterface {

    @Override
    public int echoMessage(String str) throws RemoteException {
        System.out.println( "Got a message from the client: " + str );
        
        return str.length();
    }
    
}
