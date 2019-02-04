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




## Autores

* **Andres Giovanne Florez Perez**  ARSW-LAB1 - [andresflorezp] (https://github.com/andresflorezp)

* **Juan Nicolas Nontoa Caballero**  ARSW-LAB1 - [nontoa] (https://github.com/nontoa)

Consulte también la lista de [colaboradores] (https://github.com/andresflorezp/ARSW-LAB1/graphs/contributors) que participaron en este proyecto.

## licencia

Este proyecto está licenciado bajo la Licencia MIT - vea el archivo [LICENSE](LICENSE) para más detalles.

