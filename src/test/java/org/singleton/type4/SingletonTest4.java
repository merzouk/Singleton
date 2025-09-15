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
 * Fichier 		:	SingletonTest4.java
 * Créé le 		: 	8 sept. 2025 à 07:54:39
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.singleton.type4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * A Renseigner.
 * @author  : admins
 * @project : Singleton
 * @package : org.singleton.type4
 * @date    : 8 sept. 2025 07:54:39
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class SingletonTest4
{
   @Test
   public void singleton1Test() throws NoSuchMethodException, 
                                       SecurityException, 
                                       InstantiationException, 
                                       IllegalAccessException, 
                                       IllegalArgumentException, 
                                       InvocationTargetException
   {
      System.out.println( "\nsingleton1Test()\n" );
      System.out.println( "\n================================================================\n" );
      /**
       * Create first instance of Singleton
       */
      Singleton singletonA = Singleton.getSingleton();
      /**
       * 
       */
      Constructor<?> constructor = singletonA.getClass().getDeclaredConstructor( new Class[0] );
      constructor.setAccessible( true );
      /**
       * Create second instance of Singleton
       */
      Singleton singletonB = (Singleton) constructor.newInstance();
      compareObject( singletonA, singletonB );
      /**
       * set Value attribut 
       */
      singletonA.setValue( 1 );
      singletonA.setName( "One" );
      singletonB.setValue( 2 );
      singletonB.setName( "Two" );
      /**
       * Check number instance of Singleton Class
       */
      compareObject( singletonA, singletonB );
   }
   
   private void compareObject( Singleton singletonA, Singleton singletonB )
   {
      /**
       * Check number instance of Singleton Class
       */
      if( singletonA.equals( singletonB ) )
      {
         System.out.println( "Two objects are same" );
      }
      else
      {
         System.out.println( "Two objects are not same" );
      }
      /**
       * 
       */
      System.out.println( singletonA.toString() + " : " + singletonA.Signature() );
      System.out.println( singletonB.toString() + " : " + singletonB.Signature() );
   }
}
