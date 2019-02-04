package edu.eci.arsw.threads;

import java.util.*;
import java.io.*;
public class CountThreads extends Thread {
    public int A,B;
    public CountThreads(int A,int B){
        this.A=A;
        this.B=B;
    }

    @Override
    public void run() {
        super.run();
        for(int i=this.A;i<=this.B;i++){
            System.out.println(i+" Corriendo por "+Thread.currentThread().toString());
        }


    }




}