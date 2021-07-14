package com.mycompany.mygroup.core.querycontroller;

import com.mycompany.mygroup.core.querycontroller.IQuery;

public interface IQueryDispatcher
{
    String Execute(IQuery query);
}

