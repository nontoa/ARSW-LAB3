/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
import edu.eci.arsw.threads.CountThreads;
public class CountThreadsMain {
    
    public static void main(String args[]){
        CountThreads th1 = new CountThreads(0,5);
        CountThreads th2 = new CountThreads(5,10);
        CountThreads th3 = new CountThreads(10,15);
        
        //Run Threads
        th1.run();
        th2.run();
        th3.run();

    }

}
