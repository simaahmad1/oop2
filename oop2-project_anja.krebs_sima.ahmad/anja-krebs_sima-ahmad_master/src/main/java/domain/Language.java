package domain;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Locale;

public class Language {
    private ObjectProperty<Locale> locale;

    public Language(String code) {
        this.locale = new SimpleObjectProperty<Locale>(new Locale(code));
    }

    public Language() {
        this.locale = new SimpleObjectProperty<Locale>(new Locale("aa"));
    }

    public ObjectProperty<Locale> getLocale() {
        return locale;
    }
}

