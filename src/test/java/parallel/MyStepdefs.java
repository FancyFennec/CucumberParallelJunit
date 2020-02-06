package parallel;

import cucumber.api.java.en.Given;
import lombok.SneakyThrows;

public class MyStepdefs {
    @SneakyThrows
    @Given("Step from {string} in {string} feature file")
    public void step(String scenario, String file) {
        System.out.format("Thread ID - %2d - %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario,file);
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.format("Sleeping %d\n", i);
        }
    }
}
