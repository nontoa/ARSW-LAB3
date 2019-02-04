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

		for (int i = 0; i < M; i++) {
			ll.add(new CycleLifeThread());
			ll.get(ll.size() - 1).start();
			
			try {
				ll.get(ll.size() - 1).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Number Ocurrence " + answer);
	}
	
	public void run() {
		cnt++;
		if(M%2==0)answer += new HostBlackListsValidator((cnt * N) / M, ((cnt + 1) * N / M) - 1).checkHost("200.24.34.55",N);
		else answer += new HostBlackListsValidator((cnt * N) / M, ((cnt + 1) * N / M)).checkHost("200.24.34.55",N);
		
	}

}
