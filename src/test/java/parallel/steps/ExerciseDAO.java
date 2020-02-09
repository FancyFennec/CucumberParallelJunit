package parallel.steps;

import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@NoArgsConstructor
public class ExerciseDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Exercise getExerciseById(Integer id) {
        return entityManager.createQuery("from Exercise where id = : id", Exercise.class)
                .setParameter("id", id).getResultList().get(0);
    }
}
