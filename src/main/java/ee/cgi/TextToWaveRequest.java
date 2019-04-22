package ee.cgi;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TextToWaveRequest {
    final String server;
    final int port;
    final File inFilePath;
    final File outFilePath;

    public TextToWaveRequest(String server, int port, File inFilePath, File outFilePath) {
        this.server = server;
        this.port = port;
        this.inFilePath = inFilePath;
        this.outFilePath = outFilePath;
    }

    public String inputFileContent() throws IOException {
        return FileUtils.readFileToString(inFilePath, StandardCharsets.UTF_8);
    }

    public static TextToWaveRequest buildFromCmdLineArguments(String[] args) {
        String server = "localhost";
        int port = 1314;
        File inFilePath = null;
        File outFilePath = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--help")) {
                useage(null);
            }
            else if (args[i].equals("--server")) {
                i++;
                if (i >= args.length) {
                    useage("Need name after --server");
                }
                server = args[i];
            }
            else if (args[i].equals("--port")) {
                i++;
                if (i >= args.length) {
                    useage("Need name after --server");
                }

                try {
                    port = Integer.parseInt(args[i]);
                } catch (NumberFormatException ex) {
                    useage("Not a valid port number '" + args[i] + "'");
                }
            }
            else if (args[i].equals("--inFile")) {
                i++;
                inFilePath = new File(args[i]);

                if (!inFilePath.exists() && !inFilePath.canRead()) {
                    useage("Cannot read input text file: '" + args[i] + "'");
                }
            }
            else if (args[i].equals("--outFile")) {
                i++;
                outFilePath = new File(args[i]);

                if (outFilePath.exists() && !outFilePath.canWrite()) {
                    useage("Cannot write to: '" + args[i] + "'");
                }
            }
            else if (args[i].startsWith("--")) {
                useage("Unknown argument " + args[i]);
            }
        }

        if (inFilePath == null) {
            useage("No input text file");
        }
        if (outFilePath == null) {
            useage("No output wave file");
        }

        return new TextToWaveRequest(server, port, inFilePath, outFilePath);
    }

    private static void useage(String error) {
        if (error != null) {
            System.out.println("");
            System.out.println("	" + error);
        }

        System.out.println("");
        System.out.println("Useage: ee.cgi.festival.FestivalClient [options]");
        System.out.println("");
        System.out.println("	--help			Show this message.");
        System.out.println("	--server <host>		        Connect to named host.");
        System.out.println("	--port <portnum>	        Use the given port.");
        System.out.println("	--inFile <pathToFile> 	    Input text file to convert (UTF-8 encoding).");
        System.out.println("	--outFile <pathToFile>		Save result to named wav file.");

        System.exit(error != null ? 1 : 0);
    }
}
