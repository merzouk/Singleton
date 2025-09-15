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
 * Créé le 		: 	13 sept. 2025 à 19:26:02
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.singleton.type5;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Renseigner.
 * @author  : admins
 * @project : Singleton
 * @package : org.singleton.type5
 * @date    : 13 sept. 2025 19:26:02
 */
public class Singleton implements Serializable
{
   /**
    * 
    */
   private static final long      serialVersionUID = -501471076623919240L;
   
   /**
    * 
    */
   private static final Singleton instance         = new Singleton();
   
   /**
   * 
   */
   private volatile int           value            = 0;
   
   /**
    * 
    */
   private volatile String        identity         = null;
   /**
    * @return the value
    */
   public int getValue()
   {
      return value;
   }
   
   /**
    * @param value the value to set
    */
   public void setValue( int value )
   {
      this.value = value;
   }
   
   /**
    * @return the identity
    */
   public String getIdentity()
   {
      return identity;
   }
   
   /**
    * @param identity the identity to set
    */
   public void setIdentity( String identity )
   {
      this.identity = identity;
   }
   
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
   public static final Singleton getInsatance()
   {
      synchronized( instance )
      {
         return instance;
      }
   }
   
   /**
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      return Objects.hash( this.identity, this.value );
   }
   
   /**
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals( Object obj )
   {
      if( obj == null ) return false;
      /**
       * 
       */
      if( !getClass().getName().equals( obj.getClass().getName() ) ) return false;
      /**
       * 
       */
      if( obj instanceof Singleton )
      {
         Singleton other = (Singleton) obj;
         return this.identity.equals( other.getIdentity() ) && this.value == other.value;
      }
      return false;
   }
}
