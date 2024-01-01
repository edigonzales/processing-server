package ch.so.agi.processing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LandingPage
 */
@Validated
public class LandingPage {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("links")
    @Valid
    private List<Link> links = new ArrayList<Link>();

    public LandingPage title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LandingPage description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LandingPage links(List<Link> links) {
        this.links = links;
        return this;
    }

    public LandingPage addLinksItem(Link linksItem) {
        this.links.add(linksItem);
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @NotNull
    @Valid
    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LandingPage landingPage = (LandingPage) o;
        return Objects.equals(this.title, landingPage.title)
                && Objects.equals(this.description, landingPage.description)
                && Objects.equals(this.links, landingPage.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, links);
    }

    @Override
    public String toString() {
        return String.format("LandingPage{title: %s, description: %s, links: %s}", title, description, links);
    }
}