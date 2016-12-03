# Java-RMI-Example
A simple example of a Java-RMI setup using Maven

## Project Setup

There are three subprojects in this example: RMIClient, RMIServer, and RMIInterfaces.  These should be self-explanatory.  The server sets up a basic class to be used as a remote object.  The client then connects to it.  Since both the client and the server need to be able to know the definition of the interface, that is broken out into a separate project that they both have as a dependency.

This project should build out of the box with Maven.

## Running the project

Running this can be a somewhat involved task, but here's the simple way to do it:

1. Run the rmiregistry program.  This should be in $JAVA_HOME/bin.  ``rmiregistry -J-Djava.rmi.server.useCodebaseOnly=false``
2. Run the RMIServer.  Make sure that when setting the RMI server codebase, the path ends with a /, otherwise **it will not work**.  ``java -Djava.rmi.server.useCodebaseOnly=false -Djava.rmi.server.codebase=file:C:\path\to\classes\ com.rm5248.rmiserver.RMIServerMain``
3. Run the RMIClient.  Make sure that when setting the RMI server codebase, the path ends with a /, otherwise **it will not work**.  Also ensure that client.policy is accessible by the application.  ``java -Djava.rmi.server.useCodebaseOnly=false -Djava.rmi.server.codebase=file:C:\path\to\classes\ -Djava.security.policy=client.policy com.rm5248.rmiclient.RMIClientMain``

Everything should now come up and you should see a message in the server window.  The client prints out the number of characters that it sent to the server.

## Other Notes

If you improve this example in any way, feel free to send a pull request.
