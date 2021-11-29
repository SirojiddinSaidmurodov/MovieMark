package edu.keepeasy.moviemark.dto;

public class RateDto extends EntityResource {
    private byte value;
    private MovieDto movie;

    public RateDto() {
    }

    @Override
    public String toString() {
        return "RateDto{" +
                "value=" + value +
                ", movie=" + movie +
                '}';
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public MovieDto getMovie() {
        return movie;
    }

    public void setMovie(MovieDto movie) {
        this.movie = movie;
    }
}
