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

package org.singleton.type1;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

/**
 * A Renseigner.
 * @author  : admins
 * @project : ThreadSafe
 * @package : org.thread_safe.singleton
 * @date    : 7 sept. 2025 09:29:46
 */
@Testable
public class SingletonTest1
{
   @Test
   public void singletonTest()
   {
      System.out.print( "If you see the same value, then singleton was reused (yay!)");
      System.out.println("\n"); 
      System.out.println("If you see different values, then 2 singletons were created (booo!!)" + "\n\n" + "RESULT:" + "\n" );
      Singleton singleton = Singleton.getInstance( "FOO" );
      Singleton anotherSingleton = Singleton.getInstance( "BAR" );
      System.out.println( singleton.getValue() );
      System.out.println( anotherSingleton.getValue() );
   }
}
