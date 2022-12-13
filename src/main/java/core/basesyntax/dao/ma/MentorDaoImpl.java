package core.basesyntax.dao.ma;

import core.basesyntax.model.ma.Mentor;
import java.util.List;

import core.basesyntax.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class MentorDaoImpl extends PersonDaoImpl implements MentorDao {
    public MentorDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Mentor> findByAgeGreaterThan(int age) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Mentor> query = session.createQuery(
                    "FROM Mentor m where m.age = :age", Mentor.class);
            query.setParameter("age", age);
            return query.getResultList();
        } catch (Exception e) {
            throw  new RuntimeException("Can't get mentor from DB", e);
        }
    }
}
