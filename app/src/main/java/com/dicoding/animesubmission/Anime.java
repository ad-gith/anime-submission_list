package com.dicoding.animesubmission;

public class Anime {
    private String name, remarks, photo, genre, writtenby, synopsis;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGenre() { return genre; }

    public void setGenre(String genre){ this.genre = genre; }

    public String getWrittenby() { return writtenby; }

    public void setWrittenby(String writtenby){ this.writtenby = writtenby; }

    public String getSynopsis() { return synopsis; }

    public void setSynopsis(String synopsis){ this.synopsis = synopsis; }
}
