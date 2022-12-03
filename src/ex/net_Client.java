package com.mbg.game.m_snake;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class net_Client {
	private String serverIp;
	private String serverPort;

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getSpielerName() {
		return spielerName;
	}

	public void setSpielerName(String spielerName) {
		this.spielerName = spielerName;
	}

	public List<Integer> getClientPosOut() {
		return clientPosOut;
	}

	public void setClientPosOut(List<Integer> clientPosOut) {
		this.clientPosOut = clientPosOut;
	}

	public List<Integer> getServerPosIn() {
		return serverPosIn;
	}

	public void setServerPosIn(List<Integer> serverPosIn) {
		this.serverPosIn = serverPosIn;
	}

	private String clientID;
	private String spielerName;
	private List<Integer> clientPosOut;
	private List<Integer> serverPosIn;

		public void netClient(String ServerIP, String ServerPort){
			this.serverIp = ServerIP;
			this.serverPort = ServerPort;

		}

		public void serverConnect() throws IOException {
			Socket clientSocket = new Socket(this.serverIp, Integer.parseInt(this.serverPort));
			ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
			output.writeUTF("Server_SNAKE_MP_ONLINE");
			ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());

			if (input.readUTF().equals("Server_SNAKE_ist_hier")) {
				System.out.println(input.readUTF());
			}


		}

}
