package parallel.steps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Slf4j
@Repository
public class ExerciseDAO {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager entityManager;

	public Exercise getExerciseById(Integer id) {

		Exercise firstResult = (Exercise) entityManager.
				createNativeQuery("select * from exercise where id = ?", Exercise.class).
				setParameter(1, id).
				getResultList()
				.get(0);
		return firstResult;
	}
}
