package edu.eci.arsw.primefinder;
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		Control control = Control.newControl();
		Scanner sc = new Scanner(System.in);
		synchronized (control) {
			control.start();
			sc.nextLine();
			
		}
		

	}

}