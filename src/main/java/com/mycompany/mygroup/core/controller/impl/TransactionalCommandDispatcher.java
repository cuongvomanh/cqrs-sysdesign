package com.mycompany.mygroup.core.controller.impl;

import com.mycompany.mygroup.core.controller.ICommand;
import com.mycompany.mygroup.core.controller.ICommandDispatcher;

public class TransactionalCommandDispatcher implements ICommandDispatcher
{
    private final ICommandDispatcher _next;
    private final ISessionFactory _sessionFactory;
 
    public TransactionalCommandDispatcher(ICommandDispatcher next,
                                          ISessionFactory sessionFactory)
    {
        _next = next;
        _sessionFactory = sessionFactory;
    }
 
    public void Execute(ICommand command)
    {
        using (var session = _sessionFactory.GetSession())
            using (var tx = session.BeginTransaction())
            {
                try
                {
                    _next.Execute(command);
                    tx.Commit();
                }
                catch
                {
                    tx.Rollback();
                    throw;
                }
            }
    }
}

