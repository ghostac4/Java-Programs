
/**
 * Purpose : Implementation of Proxy design pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 23-03-2018
 */

package com.bridgelabz.proxypattern;

public class CommandExecutorProxy implements CommandExecutor
{

   private boolean isAdmin;
   private CommandExecutor executor;

   public CommandExecutorProxy(String user, String pwd)
   {
      if ("aniket".equals(user) && "chile".equals(pwd))
         isAdmin = true;

      executor = new CommandExecutorImpl();
   }

   @Override
   public void runCommand(String command) throws Exception
   {
      if (isAdmin)
         executor.runCommand(command);
      else {
         if (command.trim().startsWith("rm"))
            throw new Exception("rm command is not allowed for non-admin users.");
         else
            executor.runCommand(command);
      }
   }

}
