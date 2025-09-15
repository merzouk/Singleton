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
 * Fichier 		:	SingletonTest.java
 * Créé le 		: 	14 sept. 2025 à 22:03:13
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.singleton.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.commons.annotation.Testable;

/**
 * A Renseigner.
 * @author  : admins
 * @project : Singleton
 * @package : org.singleton.enums
 * @date    : 14 sept. 2025 22:03:13
 */
@Testable
@TestMethodOrder(MethodOrderer.MethodName.class)
public class SingletonTest
{
   /**
    * 
    */
   @Test
   public void testEnumSingleton01()
   {
      System.out.println( "\ntestEnumSingleton01()\n" );
      assertEquals( "DS", Singleton.INSTANCE.checkTools( "dfs" ) );
   }
   
   /**
    * 
    */
   @Test
   public void testEnumSingleton02()
   {
      System.out.println( "\ntestEnumSingleton02()\n" );
      assertEquals( "RN", Singleton.INSTANCE.checkTools( "rien" ) );
   }
   
   /**
    * 
    */
   @Test
   public void testEnumSingleton03()
   {
      System.out.println( "\ntestEnumSingleton03()\n" );
      assertEquals( "", Singleton.INSTANCE.checkTools( null ) );
   }
   
   @Test
   public void testEnumSingleton04() throws ClassNotFoundException, IOException
   {
      System.out.println( "\ntestEnumSingleton04()\n" );
      assertEquals( "boolean", Singleton.INSTANCE.resolveClass( "boolean" ).getCanonicalName() );
   }
   
   @Test
   public void testEnumSingleton05()
   {
      System.out.println( "\ntestEnumSingleton05()\n" );
      Throwable throwable = assertThrows( Throwable.class, () -> {
         Singleton.INSTANCE.resolveClass( "toto" ).getCanonicalName();
      } );
      assertEquals( ClassNotFoundException.class, throwable.getClass() );
   }
   
   @Test
   public void testEnumSingleton06()
   {
      System.out.println( "\ntestEnumSingleton06()\n" );
      System.out.println( Float.compare( 1.234512345f, 1.234512347123f ) );
      Singleton.INSTANCE.checkElements( 12, 123.34, 1234, "toto", 123.45f, "titi", true, 123, false );
   }
   
   /**
    * 
    */
   @Test
   public void testEnumSingleton07()
   {
      System.out.println( "\ntestEnumSingleton07()\n" );
      assertEquals( "TR", Singleton.INSTANCE.checkTools( "tartour" ) );
   }
   
   @Test
   public void singletonWithReflectionTest()
   {
      System.out.println( "\nsingletonWithReflectionTest()\n" );
      /**
       * Create first instance of Singleton
       */
      Singleton singletonA = Singleton.INSTANCE;
      assertNotNull( singletonA );
      /**
       * 
       */
      Singleton singletonB = null;
      try
      {
         Constructor<?> constructor = singletonA.getClass().getDeclaredConstructor( new Class[0] );
         constructor.setAccessible( true );
         /**
          * Create second instance of Singleton
          */
         singletonB = (Singleton) constructor.newInstance();
      }
      catch( Exception e )
      {
         System.err.println( e );
      }
      singletonA.setValue( "OneA" );
      System.out.println( singletonA.getValue() );
      assertEquals( null, singletonB );
      if( singletonB != null )
      {
         singletonB.setValue( "OneB" );
         System.out.println( singletonB.getValue() );
      }
   }
}
