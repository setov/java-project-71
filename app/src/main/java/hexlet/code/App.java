package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        version = "1.0")

public class App implements Runnable {

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean helpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionRequested;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", defaultValue = "stylish")
    String format;

    @Parameters(index = "0", description = "path to first file")
    String filepath1;

    @Parameters(index = "1", description = "path to second file")
    String filepath2;

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new App());
        commandLine.execute(args);
    }

    @Override
    public void run() {
        if (helpRequested) {
            CommandLine.usage(this, System.out);
        } else if (versionRequested) {
            CommandLine.usage(this, System.out);
        } else {
            var data1 = Utils.getData(filepath1);
            var data2 = Utils.getData(filepath2);
            System.out.println("Comparing files: " + data1 + " and " + data2);
            System.out.println("Output format: " + format);
        }
    }
}
