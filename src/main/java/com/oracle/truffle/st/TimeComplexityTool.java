package com.oracle.truffle.st;

import org.graalvm.options.OptionCategory;
import org.graalvm.options.OptionDescriptors;
import org.graalvm.options.OptionKey;
import org.graalvm.options.OptionStability;
import com.oracle.truffle.api.Option;
import com.oracle.truffle.api.instrumentation.Instrumenter;
import com.oracle.truffle.api.instrumentation.SourceFilter;
import com.oracle.truffle.api.instrumentation.SourceSectionFilter;
import com.oracle.truffle.api.instrumentation.StandardTags.StatementTag;
import com.oracle.truffle.api.instrumentation.StandardTags.ReadVariableTag;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import com.oracle.truffle.api.source.Source;


@Registration(id = TimeComplexityTool.ID,  name = "TimeComplexityTool", version = "0.1")
public final class TimeComplexityTool extends TruffleInstrument {

    @Option(name = "", help = "Enable time complexity (default: false).", category = OptionCategory.USER, stability = OptionStability.STABLE)
    static final OptionKey<Boolean> ENABLED = new OptionKey<>(false);


    public static final String ID = "TimeComplexityTool";

    private LineEventFactory eventFactory;
    
    @Override
    protected void onCreate(final Env env) {


        System.out.println("Custom Instrument Made");

        
        SourceFilter sf = SourceFilter.newBuilder().sourceIs((Source s) -> checkPath(s)).build();

        SourceSectionFilter.Builder builder = SourceSectionFilter.newBuilder();
        SourceSectionFilter sourcefilter = builder.sourceFilter(sf).tagIs(StatementTag.class).build(); 
        SourceSectionFilter inputfilter = builder.sourceFilter(sf).tagIs(StatementTag.class).build();       
        Instrumenter instrumenter = env.getInstrumenter();

        instrumenter.attachExecutionEventFactory(sourcefilter,inputfilter, eventFactory = new LineEventFactory(env));


        
    }

    public boolean checkPath(Source s) {   
        if (s.getPath() == null) {
            return s.getURI().toString().contains("code/");
        }
        
        return s.getURI().toString().contains("code/");  
    }


    @Override
    protected void onDispose(Env env) {       
        System.out.println("\n--------------------------------");
        for (CountEventNode eventNode : eventFactory.list) {
            System.out.println("Line Number : " + eventNode.lineNumber + " Activation count : " + eventNode.counter);
        }
        System.out.println("--------------------------------\n"); 

        System.out.println("Custom Instrument Disposed"); 
    }

    @Override
    protected OptionDescriptors getOptionDescriptors() {
        return new TimeComplexityToolOptionDescriptors();
    }


}

