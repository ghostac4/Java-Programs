
/**
 * Purpose : Implementation of Serialization and Singleton
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */

package com.bridgelabz.singletonpattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonSerializedTest
{

   public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
   {
      SerializedSingleton serializedSingleton = SerializedSingleton.getIntance();

      ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("objectserialized.ser"));
      objectOutput.writeObject(serializedSingleton);
      objectOutput.flush();
      objectOutput.close();

      ObjectInput objectInput = new ObjectInputStream(new FileInputStream("objectserialized.ser"));
      SerializedSingleton serializedSingleton2 = (SerializedSingleton) objectInput.readObject();
      objectInput.close();

      System.out.print("\n" + serializedSingleton.hashCode());
      System.out.print("\n" + serializedSingleton2.hashCode());
   }

}
