package api;

public class WeatherAPI {
    private Integer id;
    private String name;
    public WeatherAPI(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public WeatherAPI () {
        super();
    }


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
}
