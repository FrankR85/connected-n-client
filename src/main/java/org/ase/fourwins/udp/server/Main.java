package org.ase.fourwins.udp.server;

import java.io.IOException;

import org.ase.fourwins.client.udphelper.MessageListener;
import org.ase.fourwins.client.udphelper.UdpCommunicator;

public class Main {

  public static void main(String[] args) throws IOException {
    String serverHost = "localhost";
    int serverPort = 4446;
    String botname = "BotName";
    System.out.printf("Connecting to %s:%d. Botname: %s\n", serverHost, serverPort, botname);
    UdpCommunicator communicator = new UdpCommunicator(serverHost, serverPort);
    MessageListener bot = new SimpleBot(botname, communicator.getMessageSender());
    communicator.addMessageListener(bot);
    communicator.listenForMessages();
  }

}
