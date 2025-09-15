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
 * Fichier 		:	DemoSingleThread.java
 * Créé le 		: 	7 sept. 2025 à 09:29:46
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.singleton.type2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.commons.annotation.Testable;

/**
 * A Renseigner.
 * @author  : admins
 * @project : ThreadSafe
 * @package : org.thread_safe.singleton
 * @date    : 7 sept. 2025 09:29:46
 */
@Testable
@TestMethodOrder(MethodOrderer.MethodName.class)
public class SingletonTest2
{
   @Test
   public void singleton1Test() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
   {
      System.out.println( "\nsingleton1Test()\n" );
      System.out.println( "\n================================================================\n" );
      /**
       * Create first instance of Singleton
       */
      Singleton singletonA = Singleton.getInstance();
      /**
       * 
       */
      Constructor<?> constructor = singletonA.getClass().getDeclaredConstructor( new Class[0] );
      constructor.setAccessible( true );
      /**
       * Create second instance of Singleton
       */
      Singleton singletonB = (Singleton) constructor.newInstance();
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
   
   @Test
   public void singleton2Test() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
   {
      System.out.println( "\nsingleton2Test()\n" );
      System.out.println( "\n================================================================\n" );
      /**
       * Create first instance of Singleton
       */
      Singleton singletonA = Singleton.getInstance();
      /**
       * Create second instance of Singleton
       */
      Singleton singletonB = Singleton.getInstance();
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
