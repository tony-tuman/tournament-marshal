package tmarshal.model;

import com.google.gdata.model.gd.StructuredPostalAddress;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by scoan04 on 11/27/2017.
 */
public class Tournament {
    Integer id;
    String name;
    String email;
    String website;
    String description;
    StructuredPostalAddress location;
    Integer numberOfRounds;
    Integer tables;
    LocalDateTime startTime;
    LocalDateTime endTime;
    Collection<User> organizers;
    Collection<User> players;
    Collection<Round> rounds;
    Collection<ScoringItem> scoringItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StructuredPostalAddress getLocation() {
        return location;
    }

    public void setLocation(StructuredPostalAddress location) {
        this.location = location;
    }

    public Integer getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(Integer numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public Integer getTables() {
        return tables;
    }

    public void setTables(Integer tables) {
        this.tables = tables;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Collection<User> getOrganizers() {
        return organizers;
    }

    public void setOrganizers(Collection<User> organizers) {
        this.organizers = organizers;
    }

    public Collection<User> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<User> players) {
        this.players = players;
    }

    public Collection<Round> getRounds() {
        return rounds;
    }

    public void setRounds(Collection<Round> rounds) {
        this.rounds = rounds;
    }

    public Collection<ScoringItem> getScoringItems() {
        return scoringItems;
    }

    public void setScoringItems(Collection<ScoringItem> scoringItems) {
        this.scoringItems = scoringItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tournament that = (Tournament) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
