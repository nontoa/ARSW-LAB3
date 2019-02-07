package edu.eci.arsw.blacklistvalidator;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;
import java.util.List;

public class CycleLifeThread extends Thread {
	public static ArrayList<CycleLifeThread> ll;
	public static ArrayList<HostBlackListsValidator> ll2;
	public static ArrayList<Integer> X;
	public static int answer = 0;
	public static int cnt = -1;
	public static int flag = 0;
	static int M = 100;
	static int N = 80000;

	public static void main(String[] args) {
		ArrayList<CycleLifeThread> ll = new ArrayList();
		ArrayList<HostBlackListsValidator> ll2 = new ArrayList();
		X = new ArrayList();
		ll.add(new CycleLifeThread());
		ll.get(ll.size() - 1).start();
		try {
			ll.get(ll.size() - 1).join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < M + 1; i++) {
			ll.add(new CycleLifeThread());
			ll.get(ll.size() - 1).start();
		}
		for (int i = 0; i < M + 2; i++) {
			try {
				ll.get(ll.size() - 1).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (CycleLifeThread b : ll) {
			if (b.isAlive())
				flag = 1;

		}

		while (flag == 1) {
			break;

		}

		if (flag == 0) {
			int resp = 0;
			for (int a : X)
				resp += a;
			if (resp >= 5) {
				System.out.println("Resported as trustworthy");
			} else {
				System.out.println("Reported as NOT trustworthy");
			}
			// System.out.println("Numero de Ocurrencias "+resp);
		}
	}

	public void run() {

		cnt++;
		// X.add(new HostBlackListsValidator((cnt * N) / M, ((cnt + 1) * N / M)).checkHost("200.24.34.55", N));
		X.add(new HostBlackListsValidator((cnt * N) / M, ((cnt + 1) * N / M)).checkHost("202.24.34.55", N));
	}

}