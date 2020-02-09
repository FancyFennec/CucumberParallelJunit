package parallel.steps;

import cucumber.api.java.en.Given;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class MyStepdefs {

    private final ExerciseDAO exerciseDAO;

    @SneakyThrows
    @Given("Step from {string} in {string} feature file")
    public void step(String scenario, String file) {
        System.out.format("Thread ID - %2d - %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario,file);

        Exercise exerciseById = exerciseDAO.getExerciseById(1001);

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.format("Sleeping %d\n", i);
        }
    }
}
