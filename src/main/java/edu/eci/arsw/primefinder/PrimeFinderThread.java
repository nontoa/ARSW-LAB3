package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrimeFinderThread extends Thread {

	int a, b;

	private List<Integer> primes;
	public boolean espere = false;
	public int numberThread;

	public PrimeFinderThread(int a, int b) {
		super();
		this.primes = new LinkedList<>();
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);

		for (int i = a; i < b; i++) {
			if (espere) {
				synchronized (this) {

					try {
						
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			if (isPrime(i)) {
				primes.add(i);
				// System.out.println(i);
			}

		}
	}

	boolean isPrime(int n) {
		boolean ans;
		if (n > 2) {
			ans = n % 2 != 0;
			for (int i = 3; ans && i * i <= n; i += 2) {
				ans = n % i != 0;
			}
		} else {
			ans = n == 2;
		}
		return ans;
	}
	
	
	public List<Integer> getPrimes() {
		return primes;
	}

	public void detener() {

		espere = true;

	}

	public synchronized void activar() {

		espere = false;
		this.notifyAll();

	}
}