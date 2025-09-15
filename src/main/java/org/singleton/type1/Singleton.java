/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : ThreadSafe
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	Singleton.java
 * Créé le 		: 	7 sept. 2025 à 09:28:55
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.singleton.type1;

/**
 * A Renseigner.
 * @author  : admins
 * @project : ThreadSafe
 * @package : org.thread_safe.singleton
 * @date    : 7 sept. 2025 09:28:55
 */
public final class Singleton
{
   private static volatile Singleton INSTANCE;
   
   private static volatile int       a = 0;
   
   private String                    value;
   /**
    * 
    * @return
    */
   public String getValue()
   {
      return value;
   }
   
   /**
    * 
    * @param value
    */
   private Singleton( String value )
   {
      // The following code emulates slow initialization.
      try
      {
         Thread.sleep( 100 );
      }
      catch( InterruptedException ex )
      {
         ex.printStackTrace();
      }
      synchronized( value )
      {
         if( a == 0 )
         {
            a++;
            this.value = value;
         }
         if( a > 1 )
         {
            //throw new AssertionError( "No java.util.Objects instances for you!" );
         }
      }
   }
   
   public static Singleton getInstance( String value )
   {
      synchronized( value )
      {
         if( INSTANCE == null )
         {
            INSTANCE = new Singleton( value );
         }
      }
      return INSTANCE;
   }
}
