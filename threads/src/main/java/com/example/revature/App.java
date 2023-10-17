package com.example.revature;


/**
 * Hello world!
 *
 */
public class App 
{
public static void main(String[] args) {
		
		Thread emp1 = new Thread(()-> {
		    		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " is working...");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				/*
				 * InterruptedException is thrown when the Employee's interrupt()
				 * method is called. We will break out if this occurs.
				 */
				e.printStackTrace();
				break;
			}
		}
	
		    
		}); // Thread state: NEW
		emp1.setPriority(1);
//		emp1.run();	// does not actually create a new thread
		emp1.start(); // Thread state: RUNNING
		
		Employee emp2 = new Employee();
		emp2.setPriority(2);
		emp2.start();
		
		/*
		 * join() method
		 * 
		 * Using join(), we tell our thread to wait until the specified thread completes
		 * its execution. There are overloaded versions of the join() method, which allows
		 * us to specify the time for which you want to wait for the specified thread to
		 * terminate.
		 */
		try {
			emp1.join(); // Waiting for emp1 to finish its execution
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Display the priority of threads. The default priority is 5.
		System.out.println(emp1.getPriority());
		System.out.println(emp2.getPriority());
		
		// Check to see if a given thread is alive or dead
		System.out.println(emp1.isAlive());
		System.out.println(emp2.isAlive());
		
		
	}
	
static class Employee extends Thread {

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " is working...");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				/*
				 * InterruptedException is thrown when the Employee's interrupt()
				 * method is called. We will break out if this occurs.
				 */
				e.printStackTrace();
				break;
			}
		}
	}
}

}