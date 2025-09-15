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
 * Fichier 		:	TestReentrantLock.java
 * Créé le 		: 	8 sept. 2025 à 09:05:08
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.verrou;

/**
 * A Renseigner.
 * @author  : admins
 * @project : Singleton
 * @package : org.verrou
 * @date    : 8 sept. 2025 09:05:08
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock
{
   private final Lock verrou = new ReentrantLock();
   /**
    * 
    * @throws InterruptedException
    */
   public void methodeA() throws InterruptedException
   {
      verrou.lock();
      try
      {
         System.out.println( "MethodeA : " + Thread.currentThread().getName() );
         Thread.sleep( 2000 );
         methodeB();
         Thread.sleep( 5000 );
      }
      finally
      {
         verrou.unlock();
      }
   }
   
   /**
    * 
    */
   public void methodeB()
   {
      verrou.lock();
      try
      {
         System.out.println( "MethodeB : " + Thread.currentThread().getName() );
      }
      finally
      {
         verrou.unlock();
      }
   }
   
   /**
    * 
    * @param args
    */
   public static void main( String[] args )
   {
      for(int i = 0 ; i < 10 ; i++)
      {
         Thread[] threads = runThread(i+3);
         for(int j = 0 ; j < i + 3 ; threads[j++].start());
      }
   }

   private static Thread[] runThread(int index)
   {
      final TestReentrantLock sut = new TestReentrantLock();
      Thread[] threads = new Thread[index];
      
      for(int i = 0; i < index ; i++) 
      {
         threads[i] = new Thread( new Runnable()
         {
               @Override
               public void run()
               {
                  try
                  {
                     System.out.println( "debut thread "+index );
                     sut.methodeA();
                     System.out.println( "fin thread "+index );
                  }
                  catch( InterruptedException e )
                  {
                     e.printStackTrace();
                  }
               }
            }, "Thread "+index );
      }
      return threads;
   }
}