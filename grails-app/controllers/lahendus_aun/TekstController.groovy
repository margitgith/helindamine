package lahendus_aun

import ee.cgi.festival.FestivalClient
import groovy.io.FileType
import org.apache.commons.io.FileUtils

class TekstController {
    def tekst() {
    }

    def helinda() {
        def tekst = params.helindatavTekst
        FestivalClient fc = new FestivalClient();
        byte[] wawe = fc.StringToWave(tekst)
        def failinimi = tekst
        if (tekst.size()>5) {
            failinimi = failinimi.substring(0,5)
        }
        def time = new Date().getTime()
        File file = new File("./grails-app/assets/audio/" + failinimi + time + ".wav")
        FileUtils.writeByteArrayToFile(file, wawe)
        [failiNimi: file.getName()]

    }

    def kustuta() {
        def file = new File("./grails-app/assets/audio/" + params.failiNimi)
        file.delete()
        redirect(controller: "tekst", action: "nimekiri")
    }

    def nimekiri() {
        def list = []
        // list files from directory where generated audio files are saved
        def dir = new File('./grails-app/assets/audio')
        dir.eachFile (FileType.FILES) { file ->
            list << file.getName()
        }
        [nimekiri : list]
    }

}