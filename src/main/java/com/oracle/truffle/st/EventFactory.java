package com.oracle.truffle.st;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;
import com.oracle.truffle.api.instrumentation.ExecutionEventNodeFactory;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Env;


class EventFactory implements ExecutionEventNodeFactory {


    EventFactory(final Env env) {

        
    }


    public ExecutionEventNode create(final EventContext ec) {

        return new Probe();
        
    }


}