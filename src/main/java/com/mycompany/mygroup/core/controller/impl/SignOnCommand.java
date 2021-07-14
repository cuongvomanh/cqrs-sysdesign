package com.mycompany.mygroup.core.controller.impl;

import com.mycompany.mygroup.core.controller.ICommand;

import java.util.Date;

public class SignOnCommand implements ICommand
{
    private Integer id ;
    private Date date;
 
    public SignOnCommand(Integer assignmentId, Date effectiveDate)
    {
        this.id = assignmentId;
        this.date = effectiveDate;
    }
}
