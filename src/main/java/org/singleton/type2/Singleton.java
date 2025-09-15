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
 * Fichier 		:	Singleton2.java
 * Créé le 		: 	7 sept. 2025 à 09:49:02
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.singleton.type2;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Renseigner.
 * @author  : admins
 * @project : ThreadSafe
 * @package : org.thread_safe.singleton
 * @date    : 7 sept. 2025 09:49:02
 */
public final class Singleton implements Serializable
{
   private int               value;
   
   private String            name;
   
   /**
    * 
    */
   @java.io.Serial
   private static final long serialVersionUID = -5506653524509750822L;
   /** 
    * 
    * Constructeur privé 
    */
   private Singleton()
   {
   }
   /** 
    * 
    * Instance unique pré-initialisée 
    * 
    */
   private static final Singleton INSTANCE = new Singleton();
   /** 
    * 
    * Point d'accès pour l'instance unique du singleton 
    * 
    */
   public static Singleton getInstance()
   {
      return INSTANCE;
   }
   
   /** 
    * 
    * Sécurité anti-désérialisation 
    * 
    */
   private Object readResolve()
   {
      return INSTANCE;
   }
   
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
