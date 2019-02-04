package edu.eci.arsw.blacklistvalidator;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;
import java.util.List;

public class CycleLifeThread extends Thread {
	public static ArrayList<CycleLifeThread> ll;
	public static ArrayList<HostBlackListsValidator> ll2;
	public static ArrayList<Integer> X;
	public static ArrayList<Integer> Y;
	public static int answer = 0;
	public static int cnt = -1;
	static int M = 5000;
	static int N = 80000;

	public static void main(String[] args) {
		ArrayList<CycleLifeThread> ll = new ArrayList();
		ArrayList<HostBlackListsValidator> ll2 = new ArrayList();
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			X.add(i * N / M);
			Y.add(((i + 1) * N / M) - 1);
			ll2.add(new HostBlackListsValidator(i * N / M, ((i + 1) * N / M) - 1));
		}

		for (int i = 0; i < M; i++) {
			ll.add(new CycleLifeThread());
			ll.get(ll.size() - 1).start();
			
			try {
				ll.get(ll.size() - 1).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		for (int i = 0; i < M; i++) {
		
		}
		System.out.println("Number Ocurrence " + answer);
	}
	
	public void run() {
		cnt++;
		answer += new HostBlackListsValidator((cnt * N) / M, ((cnt + 1) * N / M) - 1).checkHost("200.24.34.55");
	}

}
