package sk.stuba.fei.uim.asos.assignment2;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public LocalDate unmarshal(String value) throws Exception {
        return LocalDate.parse(value, formatter);
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        if (date != null) {
            return date.format(formatter);
        } else {
            return null;
        }
    }
}