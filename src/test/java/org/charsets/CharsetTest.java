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
 * Fichier 		:	CharsetTest.java
 * Créé le 		: 	12 sept. 2025 à 07:44:43
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.charsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.charset.IllegalCharsetNameException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.commons.annotation.Testable;

/**
 * A Renseigner.
 * @author  : admins
 * @project : Singleton
 * @package : org.charsets
 * @date    : 12 sept. 2025 07:44:43
 */
@Testable
@TestMethodOrder(MethodOrderer.MethodName.class)
public class CharsetTest
{
   @Test
   public void charsetTest01()
   {
      assertEquals( CharsetMain.checkName( "AZERTY_1234_:-.+_azerty" ), true );
   }
   
   @Test
   public void charsetTest02()
   {
      assertEquals( CharsetMain.checkName( "AZERTY_1234_:-.+_azerty!" ), false );
   }
   
   @Test
   public void charsetTest03()
   {
      assertEquals( CharsetMain.checkName( "AZERTY_1234_:-.+_azerty?" ), false );
   }
   
   @Test
   public void charsetTest04()
   {
      Throwable throwable = assertThrows( Throwable.class, () -> {
         CharsetMain.checkName( null );
      } );
      assertEquals( IllegalCharsetNameException.class, throwable.getClass() );
   }
   
   @Test
   public void charsetTest05()
   {
      assertEquals( assertThrows( IllegalCharsetNameException.class, () -> {
         CharsetMain.checkName( "" );
      } ).getClass(), IllegalCharsetNameException.class );
   }
   
   @Test
   public void charsetTest06()
   {
      assertEquals( CharsetMain.checkName( "?:::::" ), false );
   }
}
