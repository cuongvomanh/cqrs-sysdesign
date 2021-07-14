package com.mycompany.mygroup.core.controller.impl;

import com.mycompany.mygroup.core.controller.ICommand;
import com.mycompany.mygroup.core.controller.ICommandHandler;

public class SignOnCommandHandler implements ICommandHandler
{
    private final AssignmentRepository _assignmentRepository;
    private final SignOnPolicyFactory _factory;
 
    public SignOnCommandHandler(AssignmentRepository assignmentRepository,
                                SignOnPolicyFactory factory)
    {
        _assignmentRepository = assignmentRepository;
        _factory = factory;
    }
 
    public void Execute(ICommand command)
    {
        var assignment = _assignmentRepository.GetById(command.Id);
 
        if (assignment == null)
        {
            throw new MeaningfulDomainException("Assignment not found!");
        }
 
        var policy = _factory.GetPolicy();
 
        assignment.SignOn(command.EffectiveDate, policy);
    }
}

