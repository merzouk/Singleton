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
 * Créé le 		: 	14 sept. 2025 à 22:01:10
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.singleton.enums;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/**
 * A Renseigner.
 * @author  : admins
 * @project : Singleton
 * @package : org.singleton.enums
 * @date    : 14 sept. 2025 22:01:10
 */
public enum Singleton implements Serializable
{
   INSTANCE;
   /**
    * 
    */
   private Singleton()
   {
   }
   /**
    * 
    */
   private String value = "";
   /**
    * @return the value
    */
   public String getValue()
   {
      return this.value;
   }
   
   /**
    * @param value the value to set
    */
   public void setValue( String value )
   {
      this.value = value;
   }
   
   /**
    * 
    * @param str
    * @return
    */
   public String checkTools( String str )
   {
      if( str == null ) return "";
      if( "rien".equalsIgnoreCase( str )) return "RN";
      if(str.length() == 2) return str.toUpperCase();
      
      StringBuffer a = new StringBuffer(str);
      String r = "";
      char c = a.charAt( 0 );
      r += c;
      c = a.charAt( str.length() - 1 );
      r += c;
      return r.toUpperCase();
   }
   
   /**
    * immutable table mapping primitive type names to corresponding
    * class objects
    */
   private final Map<String, Class<?>> primClasses =        Map.of("boolean", boolean.class,
                                                                   "byte", byte.class,
                                                                   "char", char.class,
                                                                   "short", short.class,
                                                                   "int", int.class,
                                                                   "long", long.class,
                                                                   "float", float.class,
                                                                   "double", double.class,
                                                                   "void", void.class,
                                                                   "integer", Integer.class
                                                                   );
   /**
    * 
    * 
    * 
    * @param nameOfClass
    * @return Class of nameOfClass type 
    * @throws IOException
    * @throws ClassNotFoundException
    */
   public final Class<?> resolveClass( String nameOfClass ) throws IOException, ClassNotFoundException
   {
      Class<?> clazz = null;
      try
      {
         clazz = primClasses.get( nameOfClass );         
      }
      catch( Exception e )
      {
         System.err.println( e );
      }
      if( clazz != null )
      {
         return clazz;
      }
      throw new ClassNotFoundException( "Not class found : "+nameOfClass );
   }
   
   /**
    * Check list elements of elipsis content
    * 
    * @param args : argument's list
    */
   public final void checkElements(Object ... args)
   {
      int a = 0;
      for(Object arg : args)
      {
         a++;
         if(arg instanceof String) 
         {
            String s = (String) arg;
            System.out.println(a + " arg String value =>    " + s );
         }
         if(arg instanceof Integer) 
         {
            int i = (Integer) arg;
            System.out.println(a + " arg Integer value =>    " + i );
         }
         if(arg instanceof Double) 
         {
            double d = (Double) arg;
            System.out.println(a + " arg Double value =>    " + d );
         }
         if(arg instanceof Float)
         {
            float f = (Float) arg;
            System.out.println(a + " arg Float value =>    " + f );
         }
         if(arg instanceof Boolean)
         {   
            boolean b = (Boolean) arg;
            System.out.println(a + " arg Boolean value =>    " + b );
         }
      }
   }
}
