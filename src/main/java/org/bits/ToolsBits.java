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
 * Fichier 		:	Tools.java
 * Créé le 		: 	12 sept. 2025 à 10:16:24
 * Auteur		: 	admins
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */
package org.bits;

/**
 * A Renseigner.
 * @author  : admins
 * @project : Singleton
 * @package : org.bits
 * @date    : 12 sept. 2025 10:16:24
 */
class ToolsBits
{
   /*
    * Methods for unpacking primitive values from byte arrays starting at
    * given offsets.
    */

   static boolean getBoolean(byte[] b, int off) {
       return b[off] != 0;
   }

   static char getChar(byte[] b, int off) {
       return (char) ((b[off + 1] & 0xFF) +
                      (b[off] << 8));
   }

   static short getShort(byte[] b, int off) {
       return (short) ((b[off + 1] & 0xFF) +
                       (b[off] << 8));
   }

   static int getInt(byte[] b, int off) {
       return ((b[off + 3] & 0xFF)      ) +
              ((b[off + 2] & 0xFF) <<  8) +
              ((b[off + 1] & 0xFF) << 16) +
              ((b[off    ]       ) << 24);
   }

   static float getFloat(byte[] b, int off) {
       return Float.intBitsToFloat(getInt(b, off));
   }

   static long getLong(byte[] b, int off) {
       return ((b[off + 7] & 0xFFL)      ) +
              ((b[off + 6] & 0xFFL) <<  8) +
              ((b[off + 5] & 0xFFL) << 16) +
              ((b[off + 4] & 0xFFL) << 24) +
              ((b[off + 3] & 0xFFL) << 32) +
              ((b[off + 2] & 0xFFL) << 40) +
              ((b[off + 1] & 0xFFL) << 48) +
              (((long) b[off])      << 56);
   }

   static double getDouble(byte[] b, int off) {
       return Double.longBitsToDouble(getLong(b, off));
   }

   /*
    * Methods for packing primitive values into byte arrays starting at given
    * offsets.
    */

   static byte[] putBoolean(byte[] b, int off, boolean val) {
       b[off] = (byte) (val ? 1 : 0);
       return b;
   }

   static byte[] putChar(byte[] b, int off, char val) {
       b[off + 1] = (byte) (val      );
       b[off    ] = (byte) (val >>> 8);
       return b;
   }

   static byte[] putShort(byte[] b, int off, short val) {
       b[off + 1] = (byte) (val      );
       b[off    ] = (byte) (val >>> 8);
       return b;
   }

   static byte[] putInt(byte[] b, int off, int val) {
       b[off + 3] = (byte) (val       );
       b[off + 2] = (byte) (val >>>  8);
       b[off + 1] = (byte) (val >>> 16);
       b[off    ] = (byte) (val >>> 24);
       return b;
   }

   static byte[] putFloat(byte[] b, int off, float val) {
      return putInt(b, off,  Float.floatToIntBits(val));
   }

   static byte[] putLong(byte[] b, int off, long val) {
       b[off + 7] = (byte) (val       );
       b[off + 6] = (byte) (val >>>  8);
       b[off + 5] = (byte) (val >>> 16);
       b[off + 4] = (byte) (val >>> 24);
       b[off + 3] = (byte) (val >>> 32);
       b[off + 2] = (byte) (val >>> 40);
       b[off + 1] = (byte) (val >>> 48);
       b[off    ] = (byte) (val >>> 56);
       return b;
   }

   static byte[] putDouble(byte[] b, int off, double val) {
       return putLong(b, off, Double.doubleToLongBits(val));
   }
}
