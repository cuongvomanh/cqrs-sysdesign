package com.mycompany.mygroup.core.controller.impl;

import com.mycompany.mygroup.core.controller.ICommand;

public class CommandDispatcher implements ICommandDispatcher
{
    private readonly IDependencyResolver _resolver;
 
    public CommandDispatcher(IDependencyResolver resolver);
 
    public void Execute(ICommand command) {
    {
        if(command == null)
        {
            throw new ArgumentNullException("command");
        }
 
        var handler = _resolver.Resolve>();
 
        if (handler == null)
        {
            throw new CommandHandlerNotFoundException(typeof(TCommand));
        }
 
        handler.Execute(command);
    }
}

