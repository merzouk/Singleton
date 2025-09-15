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
 * Fichier 		:	Main.java
 * Créé le 		: 	12 sept. 2025 à 06:52:49
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.charsets;

import java.nio.charset.IllegalCharsetNameException;

/**
 * A Renseigner.
 * @author  : admins
 * @project : Singleton
 * @package : org.charsets
 * @date    : 12 sept. 2025 06:52:49
 */
public final class CharsetMain
{ 
   private CharsetMain()
   {
      throw new AssertionError( "No java.util.Objects instances for you!" );
   }
   
   
   public static final boolean checkName( String s )
   {
      if( s == null )
      {
         throw new IllegalCharsetNameException( s );
      }
      int n = s.length();
      if( n == 0 )
      {
         throw new IllegalCharsetNameException( s );
      }
      for( int i = 0; i < n; i++ )
      {
         char c = s.charAt( i );
         if( c >= 'A' && c <= 'Z' ) continue;
         if( c >= 'a' && c <= 'z' ) continue;
         if( c >= '0' && c <= '9' ) continue;
         if( c == '-' && i != 0 ) continue;
         if( c == '+' && i != 0 ) continue;
         if( c == ':' && i != 0 ) continue;
         if( c == '_' && i != 0 ) continue;
         if( c == '.' && i != 0 ) continue;
         return false;
         //throw new IllegalCharsetNameException( s );
      }
      return true;
   }
}
