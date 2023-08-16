package com.oracle.truffle.st;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;

public class Probe extends ExecutionEventNode{


    public Probe()
    {

    }

    @Override
    public void onEnter(final VirtualFrame frame) {
        System.out.println("In call tag");
    }





}
