package com.oracle.truffle.st;

public class Timestamp {

    private final String method;
    public long StartTime;
    public long EndTime;

    public Timestamp(String method)
    {
        this.method = method;
    }

    public String getTime(){
        return (EndTime-StartTime)/1000000 + "ms";
    }

    public String getMethodName(){
        return method;
    }

    
}
