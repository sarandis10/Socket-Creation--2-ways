package com.sarandis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketForServer {

	public static void main(String[] args) throws Exception
	{
		System.out.println("Server: server is working....!");
		ServerSocket ss=new ServerSocket(8090);
		
		System.out.println("Server:server is wating for client");
		Socket s=ss.accept();
		
		System.out.println("Server:client connected!! everything works properly!");
		
		BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str=br.readLine();
		
		System.out.println("Server:Client sends the following data: "+ str);	
		
		String part=str.substring(0,5);
		
		OutputStreamWriter osw=new OutputStreamWriter(s.getOutputStream());
		PrintWriter out= new PrintWriter(osw);
		out.println(part);
		out.flush();
		System.out.println("Server:Server sent data back to client! yea!!");
	}
}
