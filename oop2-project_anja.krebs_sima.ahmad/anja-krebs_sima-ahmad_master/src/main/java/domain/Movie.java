package domain;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Movie {

    private StringProperty title;
    private IntegerProperty year;
    private StringProperty genre;
    private String language;
    private StringProperty director;
    private StringProperty company;
    private String country;
    private BooleanProperty seen;
    private IntegerProperty rating;

    private ObjectProperty<Integer> duration;
    private ObjectProperty<Long> boxOffice;
    private ObjectProperty<Long> cost;
    private ObservableList<String> cast;

    private Country countryLocale;
    private Language languageLocale;

    public Movie(String title, Integer year,String genre, Integer duration, String language, String director, List<String> cast, String company, String country,
                 Long boxOffice,  Long cost, Boolean seen, Integer rating) {
        this.title = new SimpleStringProperty(title);
        this.year = new SimpleIntegerProperty(year);
        this.genre = new SimpleStringProperty(genre);
        this.language = language;
        this.director = new SimpleStringProperty(director);
        this.company = new SimpleStringProperty(company);
        this.country = country;
        this.seen = new SimpleBooleanProperty(seen);
        this.rating = new SimpleIntegerProperty(rating);
        this.duration = new SimpleObjectProperty<Integer>(duration);
        this.boxOffice = new SimpleObjectProperty<Long>(boxOffice);
        this.cost = new SimpleObjectProperty<Long>(cost);
        if(cast != null) {
            this.cast = new ObservableListWrapper<String>(cast);
        } else {
            this.cast = FXCollections.observableArrayList();
        }
        setLocalesfromCode();
        setLocalesfromCode();
    }

    public Movie() {
        this.title = new SimpleStringProperty("New Film");
        this.genre = new SimpleStringProperty("");
        this.language = "";
        this.director = new SimpleStringProperty("");
        this.company = new SimpleStringProperty("");
        this.country = "";
        this.seen = new SimpleBooleanProperty(false);
        this.rating = new SimpleIntegerProperty();
        this.year = new SimpleIntegerProperty();
        this.duration = new SimpleObjectProperty<Integer>();
        this.boxOffice = new SimpleObjectProperty<Long>();
        this.cost = new SimpleObjectProperty<Long>();
        this.cast = FXCollections.observableArrayList(new ArrayList<>());
        this.cast.addAll(cast);
        this.countryLocale = new Country();
        this.languageLocale = new Language();
    }

    public void setLocalesfromCode() {
        countryLocale = new Country(country);
        languageLocale = new Language(language);
    }

    public void syncCountryLanguage() {
        language = languageLocale.getLocale().get().getLanguage();
        country = countryLocale.getLocale().get().getCountry();
    }


    public void setTitle(String title) {
        this.title.set(title);
    }
    public StringProperty getTitle() {
        return title;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public IntegerProperty getYear() {
        return year;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public StringProperty getGenre() {
        return genre;
    }

    public void setDirector(String director) {
        this.director.set(director);
    }

    public StringProperty getDirector() {
        return director;
    }

    public void setCompany(String company) {
        this.company.set(company);
    }

    public StringProperty getCompany() {
        return company;
    }

    public void setSeen(boolean seen) {
        this.seen.set(seen);
    }

    public BooleanProperty getSeen() {
        return seen;
    }

    public void setRating(int rating) {
        this.rating.set(rating);
    }

    public IntegerProperty getRating() {
        return rating;
    }

    public void setDuration(Integer duration) {
        this.duration.set(duration);
    }

    public ObjectProperty<Integer> getDuration() {
        return duration;
    }

    public void setBoxOffice(Long boxOffice) {
        this.boxOffice.set(boxOffice);
    }

    public ObjectProperty<Long> getBoxOffice() {
        return boxOffice;
    }

    public void setCost(Long cost) {
        this.cost.set(cost);
    }

    public ObjectProperty<Long> getCost() {
        return cost;
    }

    public void setCast(ObservableList<String> cast) {
        this.cast = cast;
    }

    public ObservableList<String> getCast() {
        return cast;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Country getCountry() {
        return countryLocale;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Language getLanguage() {
        return languageLocale;
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + "]";
    }


}


