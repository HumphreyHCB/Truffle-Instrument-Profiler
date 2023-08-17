package com.oracle.truffle.st;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;
import com.oracle.truffle.api.instrumentation.ExecutionEventNodeFactory;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Env;


class EventFactory implements ExecutionEventNodeFactory {

    private List<Timestamp> Timings;

    EventFactory(final Env env, List<Timestamp> Timings) {
        this.Timings = Timings;
        
    }


    public ExecutionEventNode create(final EventContext ec) {
        
        Timestamp ts = new Timestamp(ec.getInstrumentedNode().getRootNode().toString());
        Timings.add(ts);
        return new Probe(ts);
        
    }


}