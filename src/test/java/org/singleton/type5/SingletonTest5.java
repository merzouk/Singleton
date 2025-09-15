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
 * Fichier 		:	SingletonTest5.java
 * Créé le 		: 	13 sept. 2025 à 19:27:22
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.singleton.type5;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
 * @package : org.singleton.type5
 * @date    : 13 sept. 2025 19:27:22
 */
@Testable
@TestMethodOrder(MethodOrderer.MethodName.class)
public class SingletonTest5
{
   /**
    * 
    */
   @Test
   public void TestWithoutReflection()
   {
      Singleton singleton1 = Singleton.getInsatance();
      /**
       * 
       */
      Singleton singleton2 = Singleton.getInsatance();
      /**
       * 
       */
      singleton1.setValue( 1 );
      singleton1.setIdentity( "singleton1" );
      /**
       * 
       */
      singleton2.setValue( 2 );
      singleton2.setIdentity( "singleton2" );
      /**
       * 
       */
      assertTrue( singleton1.equals( singleton2 ) );
   }
   
   /**
    * 
    * @throws NoSuchMethodException
    * @throws SecurityException
    * @throws InstantiationException
    * @throws IllegalAccessException
    * @throws IllegalArgumentException
    * @throws InvocationTargetException
    */
   @Test
   public void TestWithReflection() throws NoSuchMethodException, 
                                           SecurityException, 
                                           InstantiationException, 
                                           IllegalAccessException, 
                                           IllegalArgumentException, 
                                           InvocationTargetException
   {
      Singleton singleton1 = Singleton.getInsatance();
      /**
       * 
       */
      Constructor<? extends Singleton> constructor = singleton1.getClass().getDeclaredConstructor( new Class[0] );
      constructor.setAccessible( true );
      /**
       * 
       */
      Singleton singleton2 = (Singleton) constructor.newInstance();
      /**
       * 
       */
      singleton1.setValue( 1 );
      singleton1.setIdentity( "singleton1" );
      /**
       * 
       */
      singleton2.setValue( 2 );
      singleton2.setIdentity( "singleton2" );
      /**
       * 
       */
      assertTrue( !singleton1.equals( singleton2 ) );
   }
}
