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
 * Fichier 		:	MonThread.java
 * Créé le 		: 	8 sept. 2025 à 08:33:09
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
 * @date    : 8 sept. 2025 08:33:09
 */
public class MonThread extends Thread
{
   private volatile boolean running = true;
   
   private final String     str     = "TRUE";
   /**
    * 
    */
   public void arreter()
   {
      this.running = false;
   }
   
   /**
    * 
    * @see java.lang.Thread#run()
    */
   @Override
   public void run()
   {
      synchronized( str )
      {
         while( running )
         {
            // traitements du thread
            try
            {
               Thread.sleep( 500 );
            }
            catch( InterruptedException ex )
            {
               ex.printStackTrace();
            }
         }
      }
   }
}
