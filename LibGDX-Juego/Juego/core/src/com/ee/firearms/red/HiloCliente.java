package com.ee.firearms.red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.badlogic.gdx.Gdx;
import com.ee.firearms.utiles.Utiles;

public class HiloCliente extends Thread {

	private DatagramSocket conexion;
	private boolean fin = false;
	private InetAddress ipServer;
	private int puertoServer; 

	public HiloCliente() {
		
		try {
			//"255.255.255.255"
//			ipServer = InetAddress.getByName("192.168.0.59");
			ipServer = InetAddress.getByName("192.168.0.13");
			puertoServer = 9999;
			
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			conexion = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		do {
			byte[] data = new byte[1024];
			DatagramPacket paquete = new DatagramPacket(data,data.length);			
			try {
				conexion.receive(paquete);
				procesarMensaje(paquete);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}while(!fin);
	
	}


	private void procesarMensaje(DatagramPacket paquete) {
		String msg = (new String(paquete.getData())).trim();
		
		String msgArray[] = msg.split("!");
		
		if (msgArray[0].equals("conexionAceptada")) {
			System.out.println("Cliente conectado");
			Utiles.listener.asignarNumero(Integer.parseInt(msgArray[1]));
		}
		else if (msgArray[0].equals("pick")) {
			Utiles.listener.permitirPick(Boolean.parseBoolean(msgArray[1]));
		}
		else if (msgArray[0].equals("forcePick")) {
			System.out.println("force");
			
			final int p = Integer.parseInt(msgArray[1]);
			
			Gdx.app.postRunnable(new Runnable() {
				@Override
				public void run() {
					Utiles.listener.forzarPick(p);
				}
			});
		}
		else if (msgArray[0].equals("start")) {
			System.out.println("inicia");
			
			Gdx.app.postRunnable(new Runnable() {

				@Override
				public void run() {
					Utiles.listener.iniciar();
				}
				
			});
			
		}
		else if (msgArray[0].equals("personaje")) {
			
			if (msgArray[1].equals("asignar")) {
				
				final int nJugador = Integer.parseInt(msgArray[2]);
				final int nPersonaje = Integer.parseInt(msgArray[3]);
				final int nArma = Integer.parseInt(msgArray[4]);
				
				Gdx.app.postRunnable(new Runnable() {
					@Override
					public void run() {
						Utiles.listener.asignarPersonaje(nJugador, nPersonaje, nArma);
					}			
				});
			}
			else if (msgArray[1].equals("coords")) {
				Utiles.listener.updatePersonaje(Integer.parseInt(msgArray[2]), Float.parseFloat(msgArray[3]), Float.parseFloat(msgArray[4]), Float.parseFloat(msgArray[5]), Float.parseFloat(msgArray[6]));
			}
			else if(msgArray[1].equals("atk")) {
				
				final int nJugador = Integer.parseInt(msgArray[2]);
				
				Gdx.app.postRunnable(new Runnable() {
					@Override
					public void run() {
						Utiles.listener.ataquePersonaje(nJugador);
					}
				});
				
				
			}
			else if(msgArray[1].equals("da?o")) {
				Utiles.listener.da?arPersonaje(Integer.parseInt(msgArray[2]), Integer.parseInt(msgArray[3]));
			}
		}
		
		else if (msgArray[0].equals("ent")) {
			if (msgArray[1].equals("coords")) {
				Utiles.listener.updateEntidadDa?o(Integer.parseInt(msgArray[2]), Float.parseFloat(msgArray[3]), Float.parseFloat(msgArray[4]) , Float.parseFloat(msgArray[5]));
			}
			else if (msgArray[1].equals("dest")) {
				Utiles.listener.destruirEntidadDa?o(Integer.parseInt(msgArray[2]));
			}
		}
		
		else if(msgArray[0].equals("fin")) {
			
			final int ganador = Integer.parseInt(msgArray[1]);
			
			Gdx.app.postRunnable(new Runnable() {
				@Override
				public void run() {
					Utiles.listener.fin(ganador);
				}
			});
			
			fin = true;
			
		}
		
	}



	public void enviarMensaje(String msg) {
		byte[] data = msg.getBytes();
		DatagramPacket paquete = new DatagramPacket(data, data.length, ipServer, puertoServer);
		try {
			conexion.send(paquete);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
