package Methods;

public class Cat {
    private String name;
    private String URL;
    private String votes;

    public Cat(){

    }

    public Cat(String name,String URL, String votes){
        this.name=name;
        this.URL=URL;
        this.votes=votes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }
}
