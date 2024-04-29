import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TextSchreiber implements Verwaltung {

	@Override
	public void writeToFile(String dateiname, ArrayList<Ladung> ladungsverzeichnis) {
		DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new BufferedOutputStream(
                    new FileOutputStream(dateiname)));
            dos.writeChars(ladungsverzeichnis.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) dos.close();
            } catch (IOException ioe){}
        }
	}

}
