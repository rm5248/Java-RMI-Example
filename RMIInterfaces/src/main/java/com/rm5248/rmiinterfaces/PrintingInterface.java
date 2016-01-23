package com.rm5248.rmiinterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * A simple interface which does some printing and returning.
 * All methods that are defined in the interface must throw a RemoteException
 * 
 */
public interface PrintingInterface extends Remote {
    
    /**
     * Echo a message to the server's console, and return a number.
     * 
     * @param str
     * @return
     * @throws RemoteException 
     */
    public int echoMessage( String str ) throws RemoteException;
}
