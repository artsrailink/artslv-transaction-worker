package co.kereta.api.model;

/**
 * Created by gemuruhgeo on 20/09/16.
 */
public class DefaultSeatTest {
    private Integer numberOfPnp;

    public DefaultSeatTest() {
    }

    public DefaultSeatTest(Integer numberOfPnp) {
        this.numberOfPnp = numberOfPnp;
    }

    public Integer getNumberOfPnp() {
        return numberOfPnp;
    }

    public void setNumberOfPnp(Integer numberOfPnp) {
        this.numberOfPnp = numberOfPnp;
    }
}
