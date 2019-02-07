/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

/**
 *
 */
import java.util.*;
import java.io.*;

public class Control extends Thread {

	private final static int NTHREADS = 3;
	private final static int MAXVALUE = 30000000;
	public final static int TMILISECONDS = 5000;

	private final int NDATA = MAXVALUE / NTHREADS;

	private PrimeFinderThread pft[];

	private Control() {
		super();

		this.pft = new PrimeFinderThread[NTHREADS];

		int i;
		for (i = 0; i < NTHREADS - 1; i++) {
			PrimeFinderThread elem = new PrimeFinderThread(i * NDATA, (i + 1) * NDATA);
			pft[i] = elem;
		}
		pft[i] = new PrimeFinderThread(i * NDATA, MAXVALUE + 1);
	}

	public static Control newControl() {
		return new Control();
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < NTHREADS; i++) {
			pft[i].numberThread=i+1;
			pft[i].start();

		}
		
		for(long finaliza = System.currentTimeMillis() + TMILISECONDS;System.currentTimeMillis() <= finaliza;) {
			if (System.currentTimeMillis() >= finaliza && !terminate()) {
				for (int i = 0; i < pft.length; i++) {
					pft[i].detener();

				}
				System.out.println("Touch key");
				sc.nextLine();
				for (int i = 0; i < pft.length; i++) {
					System.out.println("The thread that is running is "+ pft[i].numberThread+" number of primes is: "+pft[i].getPrimes().size());
					pft[i].activar();
				}

				synchronized (this) {
					this.notifyAll();
				}
				finaliza = System.currentTimeMillis() + TMILISECONDS;
			} else if (System.currentTimeMillis() >= finaliza && terminate()) {
				for (int i = 0; i < pft.length; i++)
					System.out.println("The thread " + pft[i].numberThread + " have be found " + pft[i].getPrimes().size());
				System.out.println("Finish");
				System.exit(0);
			}
		}

	}
	private boolean terminate() {
    	boolean acabar = true;
    	for (int i = 0; i < pft.length && acabar; i++) {
			if(pft[i].isAlive()) acabar = false;
		}
    	return acabar;
    }

}