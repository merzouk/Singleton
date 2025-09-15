/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : Singleton
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	Main.java
 * Créé le 		: 	10 sept. 2025 à 14:09:09
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.threads;

/**
 * A Renseigner.
 * @author  : admins
 * @project : Singleton
 * @package : org.threads
 * @date    : 10 sept. 2025 14:09:09
 */
public class Main extends Thread
{
   public static int amount = 0;
   /**
    * 
    * @param args
    */
   public static void main( String[] args )
   {
      Main thread = new Main();
      thread.start();
      // Wait for the thread to finish
      while( thread.isAlive() )
      {
         System.out.println( "Waiting..." );
      }
      // Update amount and print its value
      System.out.println( "Main: " + amount );
      amount++;
      System.out.println( "Main: " + amount );
      thread.interrupt();
   }
   
   /**
    * 
    * @see java.lang.Thread#run()
    */
   public void run()
   {
      String str = "";
      synchronized( str )
      {
         amount++;
      }
   }
}
