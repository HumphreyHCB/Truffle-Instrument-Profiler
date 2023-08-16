package launchers;

import tool.Harness;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import java.nio.file.Files;
import java.nio.file.Path;
import org.json.JSONObject;


public class EspressoLauncher {
    public static void main(String[] args) {

        new EspressoLauncher().LaunchFileWithTool(args[0]);
           
    }

    public void LaunchFileWithTool(String javaProgram) {
            try(Context ctx = Context.newBuilder("java", "js")
            .option("TruffleInstrumentProfiler", "true")
            .option("java.Classpath", "classes/")
            .option("java.MultiThreaded", "true")
            .option("engine.MultiTier", "true")
            .option("engine.DynamicCompilationThresholds", "false")
            .option("engine.SingleTierCompilationThreshold", "253")
            .option("engine.CompilationFailureAction", "ExitVM")
            .allowAllAccess(true)
            .allowExperimentalOptions(true)
            .build()) {

        Value bindings = ctx.getBindings("java");
        Value harness = bindings.getMember("code." + javaProgram);
        harness.invokeMember("main", (Object) new Object[]{});       

        }catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        
    }

    

    

}

