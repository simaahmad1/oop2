package domain;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Locale;

public class Country {
    private ObjectProperty<Locale> locale;

    public Country(String code) {
        this.locale = new SimpleObjectProperty<Locale>(new Locale("", code));
    }

    public Country() {
        this.locale = new SimpleObjectProperty<Locale>(new Locale("", "AD"));
    }

    public ObjectProperty<Locale> getLocale() {
        return locale;
    }
}


