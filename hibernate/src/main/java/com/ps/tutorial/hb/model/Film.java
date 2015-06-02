package com.ps.tutorial.hb.model;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(indexes = {
        @Index(name = "idx_fk_language_id", columnList = "language_id"),
        @Index(name = "idx_fk_original_language_id", columnList = "original_language_id"),
        @Index(name = "idx_title", columnList = "title")
})
public class Film {

    public enum Rating {

        G("G"),
        PG("PG"),
        PG13("PG-13"),
        R("R"),
        NC17("NC-17");

        private String name;

        private Rating(String name) {
            this.name = name;
        }

        public static Rating parse(String name) {
            if (name != null)
                for (Rating rating : Rating.values())
                    if (rating.name.equals(name))
                        return rating;
            return null;
        }


        @Override
        public String toString() {
            return name;
        }
    }

    public enum Feature {

        TRAILERS("Trailers"),
        COMMENTARIES("Commentaries"),
        DELETED_SCENES("Deleted Scenes"),
        BEHIND_SCENES("Behind the Scenes");

        private String name;

        private Feature(String name) {
            this.name = name;
        }

        public static Feature parse(String name) {
            if (name != null)
                for (Feature feature : Feature.values())
                    if (feature.name.equals(name))
                        return feature;
            return null;
        }


        @Override
        public String toString() {
            return name;
        }
    }

    private int id;
    private String title;
    private String description;
    private Date releaseYear;
    private Language language;
    private Language originalLanguage;
    private short rentalDuration;
    private BigDecimal rentalRate;
    private int length;
    private BigDecimal replacementCost;
    private Rating rating;
    private Set<Feature> specialFeatures;
    private Set<Category> categories;
    private Set<Actor> actors;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "film_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column @Type(type = "text") // Only hibernate type
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    @ManyToOne @JoinColumn(name = "language_id", nullable = false, foreignKey = @ForeignKey(name = "fk_film_language"))
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @ManyToOne @JoinColumn(name = "original_language_id", foreignKey = @ForeignKey(name = "fk_film_language_original"))
    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @Column(nullable = false)
    public short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    @Column(nullable = false)
    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Column
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Column(nullable = false)
    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    @Column(name = "rating", nullable = false)
    private String getRatingText() {
        return rating.toString();
    }

    private void setRatingText(String rating) {
        this.rating = Rating.parse(rating);
    }

    @Transient
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    private String getSpecialFeaturesText() {
        return Joiner.on(",").skipNulls().join(specialFeatures);
    }

    private void setSpecialFeaturesText(String specialFeatures) {
        List<String> rawFeatures = Splitter.on(',').trimResults().omitEmptyStrings().splitToList(specialFeatures);
        Set<Feature> features = new HashSet<Feature>();
        for (String rawFeature : rawFeatures) features.add(Feature.parse(rawFeature));
        this.specialFeatures = features;
    }

    @Transient
    public Set<Feature> getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(Set<Feature> specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    @ManyToMany(mappedBy = "films")
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @ManyToMany(mappedBy = "films")
    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", language=" + language +
                ", originalLanguage=" + originalLanguage +
                ", rentalDuration=" + rentalDuration +
                ", rentalRate=" + rentalRate +
                ", length=" + length +
                ", replacementCost=" + replacementCost +
                ", rating=" + rating +
                ", specialFeatures=" + specialFeatures +
                ", categories(n)=" + ((categories != null) ? categories.size() : "0") +
                ", actors(n)=" + ((actors != null) ? actors.size() : "0") +
                '}';
    }

}
