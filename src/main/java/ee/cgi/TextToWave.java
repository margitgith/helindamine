package ee.cgi;

import ee.cgi.festival.FestivalClient;

import java.io.FileOutputStream;
import java.io.IOException;

public class TextToWave {

    public static void main (String[] args)
    {
        TextToWaveRequest request = TextToWaveRequest.buildFromCmdLineArguments(args);

        System.out.println("Server='" + request.server + ":" + request.port + "'");

        try {
            FestivalClient ttsClient = new FestivalClient(request.server, request.port);

            byte[] waveBytes = ttsClient.StringToWave(request.inputFileContent());

            FileOutputStream fio = new FileOutputStream(request.outFilePath);
            fio.write(waveBytes);
            fio.flush();
            fio.close();

            System.out.println("File saved to '" + request.outFilePath.toString() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
