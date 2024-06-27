package interviews.sliceSDET.containsW;

public class Weather {
    String cityName;
    int temp;

    public Weather(String cityName, int temp){
        this.cityName = cityName;
        this.temp = temp;
    }

    @Override
    public boolean equals(Object weather){
        return ((Weather) weather).getCityName().equals(cityName) &&
                ((Weather) weather).getTemp() == temp;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
