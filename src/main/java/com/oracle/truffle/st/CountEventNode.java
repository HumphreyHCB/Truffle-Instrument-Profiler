package com.oracle.truffle.st;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;

public class CountEventNode extends ExecutionEventNode{
    int counter = 0;
    final int lineNumber;

    public CountEventNode(final int lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    @Override
    public void onEnter(final VirtualFrame frame) {
        counter++; 
    }

    @Override
    public void onInputValue(VirtualFrame frame, EventContext inputContext, int inputIndex, Object inputValue)
    {

        System.out.println("Value: " + inputValue);
    }

    @Override
    public void onReturnValue(VirtualFrame frame, Object result)
    {
        frame.getArguments();
        System.out.println("result: " + result);
    }


}
