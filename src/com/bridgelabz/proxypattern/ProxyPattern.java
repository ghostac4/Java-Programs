/**
 * Purpose : Implementation of Proxy Design Pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelabz.proxypattern;

public class ProxyPattern
{

   public static void main(String[] args)
   {
      CommandExecutor commandExecutor = new CommandExecutorProxy("aniket", "chile");

      try {
         commandExecutor.runCommand("ls -ltr");
         commandExecutor.runCommand("rm -rf abc.pdf");
      } catch (Exception e) {
         System.out.print(e);
      }

      commandExecutor = new CommandExecutorProxy("aniket", "wrong");

      try {
         commandExecutor.runCommand("ls -ltr");
         commandExecutor.runCommand("rm -rf abc.pdf");
      } catch (Exception e) {
         System.out.print(e.getMessage());
      }
   }

}
