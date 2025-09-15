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
 * Créé le 		: 	8 sept. 2025 à 07:51:13
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.singleton.type4;

import java.util.Objects;

import org.singleton.type4.Singleton;

/**
 * A Renseigner.
 * @author  : admins
 * @project : Singleton
 * @package : org.singleton.type4
 * @date    : 8 sept. 2025 07:51:13
 */
public final class Singleton
{
   //private static native void registerNatives();
   static
   {
      //registerNatives();
   }
   
   /**
    * 
    */
   private int    value;
   
   /**
    * 
    */
   private String name;
   /**
    * 
    * @return
    */
   public int getValue()
   {
      return value;
   }
   
   /**
    * 
    * @param value
    */
   public void setValue( int value )
   {
      this.value = value;
   }
   
   /**
    * @param name the name to set
    */
   public void setName( String name )
   {
      this.name = name;
   }
   
   /**
    * @return the name
    */
   public String getName()
   {
      return name;
   }
   
   /**
    * 
    */
   private Singleton()
   {
   }
   /**
    * 
    */
   private static final Singleton theSingleton = new Singleton();
   /**
    * Provides the caller with the capability of performing Singleton
    * operations.
    *
    * <p>The returned {@code Singleton} object should be carefully guarded
    * by the caller, since it can be used to read and write data at arbitrary
    * memory addresses.  It must never be passed to untrusted code.
    *
    * <p>Most methods in this class are very low-level, and correspond to a
    * small number of hardware instructions (on typical machines).  Compilers
    * are encouraged to optimize these methods accordingly.
    *
    * <p>Here is a suggested idiom for using Singleton operations:
    *
    * <pre> {@code
    * class MyTrustedClass {
    *   private static final Singleton Singleton = Singleton.getSingleton();
    *   ...
    *   private long myCountAddress = ...;
    *   public int getCount() { return Singleton.getByte(myCountAddress); }
    * }}</pre>
    *
    * (It may assist compilers to make the local variable {@code final}.)
    */
   public static Singleton getSingleton()
   {
      return theSingleton;
   }
   
   /**
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      return Objects.hash( name, value );
   }
   
   /**
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals( Object obj )
   {
      if( this == obj ) return true;
      if( obj == null ) return false;
      if( getClass() != obj.getClass() ) return false;
      Singleton other = (Singleton) obj;
      return Objects.equals( name, other.name ) && value == other.value;
   }
   
   /**
    */
   public String Signature()
   {
      return "Singleton [value=" + value + ", name=" + name + "]";
   }
}
