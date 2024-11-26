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
    private boolean helpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private boolean versionRequested;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @Parameters(index = "0", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file")
    private String filepath2;

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new App());
        commandLine.execute(args);
    }

    @Override
    public void run() {
        if (helpRequested) {
            CommandLine.usage(this, System.out);
            return;
        } else if (versionRequested) {
            CommandLine.usage(this, System.out);
            return;
        } else {
            System.out.println("Comparing files: " + filepath1 + " and " + filepath2);
            System.out.println("Output format: " + format);
            // Here you can add the logic to compare the files and output the result
        }
    }
}
