package com.oracle.truffle.st;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;

public class Probe extends ExecutionEventNode{

    private Timestamp ts;
    public Probe(Timestamp ts)
    {
        this.ts = ts;
    }

    @Override
    public void onEnter(final VirtualFrame frame) {
        ts.StartTime = System.nanoTime();
    }


    @Override
    protected void onReturnValue(VirtualFrame frame, Object result) {
        ts.EndTime = System.nanoTime();
    }





}
