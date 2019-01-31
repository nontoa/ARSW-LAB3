package edu.eci.arsw.blacklistvalidator;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.List;

public class CycleLifeThread extends Thread{
	
	public static boolean running =true;
	public int A;
	public int B;
	public static HostBlackListsValidator hblv;
	
	public static void main(String[] args) throws InterruptedException {
		
		int M = 20;
		int N = 2000001;
		for(int i=0;i<M;i++) {
			new CycleLifeThread((i*N)/M,(((i+1)*N)/M)-1).start();;
		}
		/*
		CycleLifeThread cil0 = new CycleLifeThread(0,20000);
		cil0.start();
		CycleLifeThread cil1 = new CycleLifeThread(0,20000);
		cil1.start();
		CycleLifeThread cil2 = new CycleLifeThread(20001,40000);
		cil2.start();
		CycleLifeThread cil3 = new CycleLifeThread(40001,80000);
		cil3.start();
		
		cil0.join();
		cil1.join();
		cil2.join();
		cil3.join();
		*/
		//List<Integer> blackListOcurrences=hblv.checkHost("200.24.34.55");
        //System.out.println("The host was found in the following blacklists:"+blackListOcurrences);
		shutdown();
		
	}
	public CycleLifeThread(int A,int B) {
		this.A = A;
		this.B =B;
	}
	
	
	@Override
	public void run() {
		
		while(running) {
			hblv=new HostBlackListsValidator(this.A,this.B);
			//List<Integer> blackListOcurrences=hblv.checkHost("200.24.34.55");
			//System.out.println("The host was found in the following blacklists:"+blackListOcurrences);
			//System.out.println(A+", "+B);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static  void shutdown() {
		running =false;	
	}
	
	
	
	
	
	

}
