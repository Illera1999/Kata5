package kata5.view;

import kata5.model.Mail;
import kata5.model.Histograma;
import java.util.List;

public class MailHistogramBuilder {

    public static Histograma<String> build (List<Mail> miList){
        Histograma<String> histogram = new Histograma<>();
        for (Mail mail : miList) {
            histogram.increment(mail.getDomain());
        }
        return histogram;
    }
    
}
