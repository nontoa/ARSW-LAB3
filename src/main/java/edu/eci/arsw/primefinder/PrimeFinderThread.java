package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrimeFinderThread extends Thread {

	int a, b;

	private List<Integer> primes;

	public PrimeFinderThread(int a, int b) {
		super();
		this.primes = new LinkedList<>();
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		synchronized (primes) {

			for (int i = a; i < b; i++) {

				if (isPrime(i)) {
					primes.add(i);
					//System.out.println(i);
				}
				try {
					primes.wait(1);
					System.out.println("Numero de Primos Encontrados por el "+ Thread.currentThread().toString()+primes.size());
					primes.notifyAll();
					sc.nextLine();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

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

}