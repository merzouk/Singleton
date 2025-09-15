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
 * Fichier 		:	Singleton.java
 * Créé le 		: 	7 sept. 2025 à 13:45:34
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.singleton.type3;

import java.io.Serializable;
import java.nio.charset.IllegalCharsetNameException;

/**
 * A Renseigner.
 * @author  : admins
 * @project : Singleton
 * @package : org.singleton.type3
 * @date    : 7 sept. 2025 13:45:34
 */
public final class Singleton implements Serializable
{
   /**
    * 
    */
   private static final long      serialVersionUID = 5615997663730158072L;
   
   /**
    * 
    */
   private static final Singleton INSTANCE         = new Singleton();
   /**
    * 
    */
   private Singleton()
   {
   }
   
   /**
    * 
    * @return
    */
   public static final Singleton getInstance()
   {
      return INSTANCE;
   }
   
   /**
    * 
    * @param s
    * @return
    */
   public final boolean checkName( String s )
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
