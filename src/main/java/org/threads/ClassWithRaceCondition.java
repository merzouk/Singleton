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
 * Fichier 		:	MaClasseAvecRaceCondition.java
 * Créé le 		: 	8 sept. 2025 à 08:42:50
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
 * @date    : 8 sept. 2025 08:42:50
 */
public class ClassWithRaceCondition
{
   private volatile int     a    = 0;
   
   private volatile boolean flag = true;
   /**
    * 
    */
   public void execute()
   {
      flag = true;
      if( !flag )
      {
         a++;
         System.out.println( " arffff : " + a );
      }
      flag = false;
   }
   /**
    * 
    * @param args
    */
   private static int x = 0;
   /**
    * 
    * @param args
    */
   public static void main( String[] args )
   {
      final ClassWithRaceCondition maClasse = new ClassWithRaceCondition();
      /**
       * 
       */
      for( int i = 0; i < 10; i++ )
      {
         Thread thread = new Thread( new Runnable()
         {
            @Override
            public void run()
            {
               for( int i = 0; i < 10000; i++ )
               {
                  maClasse.execute();
               }
               x++;
               System.out.println( this.getClass().getName() + "  :  " + x );
            }
         } );
         thread.setName( "monThread-" + i );
         thread.start();
      }
   }
}
