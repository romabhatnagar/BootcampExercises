package Q3;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class HibernateEx {

    SessionFactory sessionFactoryBean;

    public HibernateEx(SessionFactory sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }

    HibernateEx() {

    }

    void sessionFactoryDemo() {
        String sql = "select count(*) from  user";
        Query query = sessionFactoryBean.openSession().createQuery(sql);
        System.out.println("Results are " + query.uniqueResult());
        // sessionFactoryBean.close();
    }

    public SessionFactory getSessionFactoryBean() {
        return sessionFactoryBean;
    }

    public void setSessionFactoryBean(SessionFactory sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }
}
