package parallel.steps;

import lombok.NoArgsConstructor;
import org.hibernate.Session;

@NoArgsConstructor
public class ExerciseDAO {

    public Exercise getExerciseById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Exercise where id = : id", Exercise.class)
                    .setParameter("id", id).getResultList().get(0);
        }
    }
}
