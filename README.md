# Laboratorio 3 Introducción Threads


## Empezando

>Para clonar el archivo 

git clone https://github.com/nontoa/ARSW-LAB3.git
>
### Prerrequisitos
* Maven
* Java
* Git
* Threads


### Instalación

Despues de clonar el archivo para correrlo con:

* mvn package "Esto te genera el JAR"

## Construido con

* [Maven](https://maven.apache.org/) - Gestión de dependencias

## Parte Black List Search

### Part I - Introduction to threads in JAVA
#### 1) Corriendo con un solo Thread

```java
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
            System.out.println(i+"Corriendo por "+Thread.currentThread().toString());
        }
    }

}

```
#### Main
```java
import edu.eci.arsw.threads.CountThreads;
public class CountThreadsMain {
    
    public static void main(String args[]){
        CountThreads th1 = new CountThreads(0,99);
        //Run Threads
        th1.start();
    }

}


```

        0 Count Corriendo por Thread[Thread-0,5,main]
        1 Count Corriendo por Thread[Thread-0,5,main]
        2 Count Corriendo por Thread[Thread-0,5,main]
        3 Count Corriendo por Thread[Thread-0,5,main]
        4 Count Corriendo por Thread[Thread-0,5,main]
        5 Count Corriendo por Thread[Thread-0,5,main]
        6 Count Corriendo por Thread[Thread-0,5,main]
        7 Count Corriendo por Thread[Thread-0,5,main]
        8 Count Corriendo por Thread[Thread-0,5,main]
        9 Count Corriendo por Thread[Thread-0,5,main]
        10 Count Corriendo por Thread[Thread-0,5,main]
        11 Count Corriendo por Thread[Thread-0,5,main]
        12 Count Corriendo por Thread[Thread-0,5,main]
        13 Count Corriendo por Thread[Thread-0,5,main]
        14 Count Corriendo por Thread[Thread-0,5,main]

#### 2) Corriendo con tres Threads
```java
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
import edu.eci.arsw.threads.CountThreads;
public class CountThreadsMain {
    
    public static void main(String args[]){
        CountThreads th1 = new CountThreads(0,99);
        CountThreads th2 = new CountThreads(99,199);
        CountThreads th3 = new CountThreads(200,299);
        
        //Run Threads
        th1.start();
        th2.start();
        th3.start();

    }

}

```
### Screen para tres Threads con start()

    0 Corriendo por Thread[Thread-0,5,main]
    200 Corriendo por Thread[Thread-2,5,main]
    1 Corriendo por Thread[Thread-0,5,main]
    201 Corriendo por Thread[Thread-2,5,main]
    2 Corriendo por Thread[Thread-0,5,main]
    99 Corriendo por Thread[Thread-1,5,main]
    202 Corriendo por Thread[Thread-2,5,main]
    100 Corriendo por Thread[Thread-1,5,main]
    3 Corriendo por Thread[Thread-0,5,main]
    101 Corriendo por Thread[Thread-1,5,main]
    203 Corriendo por Thread[Thread-2,5,main]
    102 Corriendo por Thread[Thread-1,5,main]
    103 Corriendo por Thread[Thread-1,5,main]
    104 Corriendo por Thread[Thread-1,5,main]
    105 Corriendo por Thread[Thread-1,5,main]

> Nota: Se ve como se alternan los hilos a esto se le denomina interleaving


### Screen para tres Threads con run()

```java
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

```
    0 Corriendo por Thread[main,5,main]
    1 Corriendo por Thread[main,5,main]
    2 Corriendo por Thread[main,5,main]
    3 Corriendo por Thread[main,5,main]
    4 Corriendo por Thread[main,5,main]
    5 Corriendo por Thread[main,5,main]
    5 Corriendo por Thread[main,5,main]
    6 Corriendo por Thread[main,5,main]
    7 Corriendo por Thread[main,5,main]
    8 Corriendo por Thread[main,5,main]
    9 Corriendo por Thread[main,5,main]
    10 Corriendo por Thread[main,5,main]
    10 Corriendo por Thread[main,5,main]
    11 Corriendo por Thread[main,5,main]
    12 Corriendo por Thread[main,5,main]

> Nota: En este caso lo cada instancia se ejecuta secuencialmente es decir run() solo ejecuta el metodo y start() prepara el hilo lo cual permite la concurrencia 

### Part II - Black List Search Exercise

Numero de Servidores Maliciosos encontrados para el servidor con ip 200.24.34.55 fueron 5 corriendolo desde el Main se encuentra en el rango de [0-10000]

```java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;


public class Main {
    
    public static void main(String a[]){
        HostBlackListsValidator hblv=new HostBlackListsValidator(0,80000);
        int blackListOcurrences=hblv.checkHost("200.24.34.55",N);
        System.out.println("The host was found in the following blacklists:"+blackListOcurrences);
        
    }
    
}


```

#COLOCAR IMAGEN ACA CORRIENDO EL MAIN


### Ejecutando checkHost con parametro N
```java
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

```

```java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class HostBlackListsValidator {
	int A;
    int B;
    private static final int BLACK_LIST_ALARM_COUNT=1;
    
    /**
     * Check the given host's IP address in all the available black lists,
     * and report it as NOT Trustworthy when such IP was reported in at least
     * BLACK_LIST_ALARM_COUNT lists, or as Trustworthy in any other case.
     * The search is not exhaustive: When the number of occurrences is equal to
     * BLACK_LIST_ALARM_COUNT, the search is finished, the host reported as
     * NOT Trustworthy, and the list of the five blacklists returned.
     * @param ipaddress suspicious host's IP address.
     * @return  Blacklists numbers where the given host's IP address was found.
     */
    public HostBlackListsValidator(int A,int B) {
		this.A=A;
        this.B=B;
	}
    
    public int checkHost(String ipaddress,int N){
        
        LinkedList<Integer> blackListOcurrences=new LinkedList<>();
        
        int ocurrencesCount=0;
        
        HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
        
        int checkedListsCount=0;
        
        //ocurrencesCount<=BLACK_LIST_ALARM_COUNT
        
        for (int i=A;i<B;i++){
            checkedListsCount++;
            if (skds.isInBlackListServer(i, ipaddress)){
                
                blackListOcurrences.add(i);
                ocurrencesCount++;
            }
           
        }
        
        if (ocurrencesCount>=BLACK_LIST_ALARM_COUNT){
            skds.reportAsNotTrustworthy(ipaddress);
        }
        else{
            skds.reportAsTrustworthy(ipaddress);
        }                
        
        LOG.log(Level.INFO, "Checked Black Lists:{0} of {1} and number ocurrences {2}", new Object[]{A, B,ocurrencesCount});
        
        return ocurrencesCount;
    }
    
    
    private static final Logger LOG = Logger.getLogger(HostBlackListsValidator.class.getName());
    
    
    
}


```

#COLOCAR IMAGEN CORRIENDO CON CycleLifeThread y corriendo y correr con la otra ip que no muestra ocurrencias


### Part III - Discussion

#COLOCAR CUAL ES LA MANERA MAS EFICIENTE DE HACER LAS PARTICIONES CON HILOS CON RESPECTO AL PROCESADOR DE L COMPUTADOR ADEMAS ESPECIFICAR COTAS DE CUANDO ES MEJOR


### Part IV - Performance Evaluation

#Calculo de los procesadores
#HACER LOS CALCULOS QUE TE PIDEN

## Parte Snake Race

#### Codigo Controlador

```java
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
		synchronized (sc) {
			System.out.println("Oprime un boton");
			sc.nextLine();
			
			for (int i = 0; i < NTHREADS; i++) {
				
				pft[i].start();
				
			}
		
			
			
		}
		

	}

}

```

#### Codigo del Main
```java
package edu.eci.arsw.primefinder;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Control control = Control.newControl();
		Scanner sc = new Scanner(System.in);
		control.start();
		sc.nextLine();

	}

}
```

#### Codigo para Calculos de Primos
```java
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
		synchronized (sc) {
			for (int i = a; i < b; i++) {

				if (isPrime(i)) {
					primes.add(i);
					//System.out.println(i);
				}
				try {
					sc.wait(1);
					System.out.println("Numero de Primos Encontrados por el "+ Thread.currentThread().toString()+primes.size());
					sc.notifyAll();
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


```

#Colocar que faltan responder las Preguntas








## Autores

* **Andres Giovanne Florez Perez**  ARSW-LAB1 - [andresflorezp] (https://github.com/andresflorezp)

* **Juan Nicolas Nontoa Caballero**  ARSW-LAB1 - [nontoa] (https://github.com/nontoa)

Consulte también la lista de [colaboradores] (https://github.com/andresflorezp/ARSW-LAB1/graphs/contributors) que participaron en este proyecto.

## licencia

Este proyecto está licenciado bajo la Licencia MIT - vea el archivo [LICENSE](LICENSE) para más detalles.

