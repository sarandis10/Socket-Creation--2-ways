package com.sarandis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketForClient {
	
	public static void main (String[] args) throws Exception
	{
		String ip="localhost";
		int port=8090;
					
		Socket s= new Socket(ip,port);
		
		//to send data
		String str="Sarandis, it works!";
		OutputStreamWriter osw=new OutputStreamWriter(s.getOutputStream());
		PrintWriter out= new PrintWriter(osw);
		out.println(str);
		osw.flush();
		
		//to get data
		BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
		String part=br.readLine();
		System.out.println("Client: data from server "+part);
	}
}
