package org.edu.eci.arsw;
import java.io.*;
import java.util.*;
public class CountThread extends Thread{
	
	public static int A;
	public static int B;
	public CountThread(int A, int B) {
		
		//super("my extending thread");
		this.A=A;
		this.B=B;
		System.out.println("my thread created" + this);	
		
	}

	public synchronized void run() {
		try {
			for (int i = A; i < B; i++) {
				System.out.println("Printing the count " + i);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			System.out.println("my thread interrupted");
		}
		System.out.println("My thread run is over");
	}
	public static void main(String args[]) throws InterruptedException {
		CountThread cnt0 = new CountThread(0,99);
		cnt0.run();
		CountThread cnt1 = new CountThread(0,99);
		cnt1.run();
		CountThread cnt2= new CountThread(99,199);
		cnt2.run();
		CountThread cnt3 = new CountThread(200,299);
		cnt3.run();
			
	}
	
	
	
}
