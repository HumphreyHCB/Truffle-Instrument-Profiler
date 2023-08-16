package com.oracle.truffle.st;

import org.graalvm.options.OptionCategory;
import org.graalvm.options.OptionDescriptors;
import org.graalvm.options.OptionKey;
import org.graalvm.options.OptionStability;
import com.oracle.truffle.api.Option;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.instrumentation.Instrumenter;
import com.oracle.truffle.api.instrumentation.SourceFilter;
import com.oracle.truffle.api.instrumentation.SourceSectionFilter;
import com.oracle.truffle.api.instrumentation.StandardTags.StatementTag;
import com.oracle.truffle.api.instrumentation.StandardTags.ReadVariableTag;
import com.oracle.truffle.api.instrumentation.StandardTags.CallTag;
import com.oracle.truffle.api.instrumentation.StandardTags.ExpressionTag;
import com.oracle.truffle.api.instrumentation.StandardTags.RootBodyTag;
import com.oracle.truffle.api.instrumentation.StandardTags.RootTag;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import com.oracle.truffle.api.source.Source;


@Registration(id = TruffleInstrumentProfiler.ID,  name = "TruffleInstrumentProfiler", version = "0.1")
public final class TruffleInstrumentProfiler extends TruffleInstrument {

    @Option(name = "", help = "Enable Truffle Instrument Profiler (default: false).", category = OptionCategory.USER, stability = OptionStability.STABLE)
    static final OptionKey<Boolean> ENABLED = new OptionKey<>(false);


    public static final String ID = "TruffleInstrumentProfiler";

    
    @Override
    protected void onCreate(final Env env) {


        System.out.println("Custom Instrument Made");

        //checks that the files are in the current dir
        SourceFilter sf = SourceFilter.newBuilder().sourceIs((Source s) -> checkPath(s)).build();

        SourceSectionFilter.Builder builder = SourceSectionFilter.newBuilder();
        SourceSectionFilter sourcefilter = builder.sourceFilter(sf).tagIs(RootTag.class).build();      
        Instrumenter instrumenter = env.getInstrumenter();

        instrumenter.attachExecutionEventFactory(sourcefilter, new EventFactory(env));


        
    }

    public boolean checkPath(Source s) { 
        if (s.getPath() == null) {
            return s.getURI().toString().contains("code/");
        }
        
        return s.getURI().toString().contains("code/");  
    }


    @Override
    protected void onDispose(Env env) {       

        System.out.println("Custom Instrument Disposed"); 
    }

    @Override
    protected OptionDescriptors getOptionDescriptors() {
        return new TruffleInstrumentProfilerOptionDescriptors();
    }


}

