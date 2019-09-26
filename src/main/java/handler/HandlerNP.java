package handler;

import unisoft.ws.FNSNDSCAWS2;
import unisoft.ws.FNSNDSCAWS2Port;
import unisoft.ws.fnsndscaws2.request.NdsRequest2;
import unisoft.ws.fnsndscaws2.response.NdsResponse2;
import utils.Printer;

import java.io.*;
import java.util.Date;
import java.util.List;

public class HandlerNP {
    private static final String WORD_SEPARATOR = " ";

    /**
     * Метод для проверки контрагентов (ИП, ЮЛ) по ИНН/КПП из текстового файла
     *
     * @param txtFile текстовый файл с базой ИНН/КПП для проверки
     */
    public static void checkNpFromFile(File txtFile) {
        NdsRequest2 request = new NdsRequest2();
        NdsRequest2.NP np;
        FNSNDSCAWS2 fns = new FNSNDSCAWS2();
        FNSNDSCAWS2Port fnsPort = fns.getFNSNDSCAWS2Port();
        List<NdsResponse2.NP> ndsResponse = null;
        Date currentDate = new Date();

        try (BufferedReader reader = new BufferedReader(new FileReader(txtFile))) {
            String line = reader.readLine();
            while (line != null) {
                np = new NdsRequest2.NP();
                String[] values = line.split(WORD_SEPARATOR);
                if (values.length == 1) {
                    np.setINN(values[0]);
                    np.setDT(currentDate.toString());
                    np.setKPP(null);
                } else {
                    np.setINN(values[0]);
                    np.setKPP(values[1]);
                    np.setDT(currentDate.toString());
                }
                request.getNP().add(np);
                line = reader.readLine();
            }
            ndsResponse = fnsPort.ndsRequest2(request).getNP();
        } catch (FileNotFoundException ex) {
            System.out.println("Указанного файла не существует");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert ndsResponse != null;
        ndsResponse.forEach(Printer::printNp);
    }
}
