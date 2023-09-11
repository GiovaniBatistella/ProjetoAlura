package br.com.alura.screenmatch.modelos;



public class Search{

    private String title;
    private String year;
    private String imdbId;
    private String type;
    private String poster;
    private String response;
    private String totalResponse;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTotalResponse() {
        return totalResponse;
    }

    public void setTotalResponse(String totalResponse) {
        this.totalResponse = totalResponse;
    }

    @Override
    public String toString() {
        return "Search{" +
                "title= " + title + "\n" +
                "year=  " + year +"\n" +
                "imdbId= " + imdbId +"\n" +
                "type= " + type +"\n" +
                "poster= " + poster +"\n" +
                "response= " + response +"\n" +
                "totalResponse= " + totalResponse;

    }
}


