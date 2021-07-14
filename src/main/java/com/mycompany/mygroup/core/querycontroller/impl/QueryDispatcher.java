package com.mycompany.mygroup.core.querycontroller.impl;

import com.mycompany.mygroup.core.querycontroller.IQuery;
import com.mycompany.mygroup.core.querycontroller.IQueryDispatcher;

public class QueryDispatcher implements IQueryDispatcher
{
    private final IDependencyResolver _resolver;
 
    public QueryDispatcher(IDependencyResolver resolver)
    {
        _resolver = resolver;
    }
 
    public String Execute(IQuery query)
    {
        if (query == null)
        {
            throw new ArgumentNullException("query");
        }
 
        var handler = _resolver.Resolve>();
 
        if (handler == null)
        {
            throw new QueryHandlerNotFoundException(typeof(TQuery));
        }
 
        return handler.Execute(query);
    }
}

