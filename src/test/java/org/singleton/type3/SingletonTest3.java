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
 * Fichier 		:	SingletonTest3.java
 * Créé le 		: 	7 sept. 2025 à 13:48:24
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.singleton.type3;

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
 * @package : org.singleton.type3
 * @date    : 7 sept. 2025 13:48:24
 */
@Testable
@TestMethodOrder(MethodOrderer.MethodName.class)
public class SingletonTest3
{
   @Test
   public void singleton3Test01() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
   {
      /**
       * Create first instance of Singleton
       */
      org.singleton.type3.Singleton singletonA = org.singleton.type3.Singleton.getInstance();
      /**
       * 
       */
      Constructor<?> constructor = singletonA.getClass().getDeclaredConstructor( new Class[0] );
      constructor.setAccessible( true );
      /**
       * Create second instance of Singleton
       */
      org.singleton.type3.Singleton singletonB = (org.singleton.type3.Singleton) constructor.newInstance();
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
      System.out.println( singletonA.toString() );
      System.out.println( singletonB.toString() );
   }
   
   @Test
   public void singleton3Test02() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
   {
      /**
       * Create first instance of Singleton
       */
      org.singleton.type3.Singleton singletonA = org.singleton.type3.Singleton.getInstance();
      System.out.println( singletonA.checkName( "titi" ) );
   }
}
