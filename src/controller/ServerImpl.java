package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by staho on 14.05.2017.
 */
public class ServerImpl extends UnicastRemoteObject implements ServerInt {
    private static final long serialVersionUID = 1L;
    protected ServerImpl() throws RemoteException{
        super();
    }
}
