package np.com.ngopal.simpleperm.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.security.auth.Subject;
import javax.swing.*;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

@Data
@NoArgsConstructor
public class PermRule<S extends PermSubject,O extends PermObject,A extends PermAction> implements Serializable {
    protected S subject;
    protected O object;
    protected A action;

    public PermRule(String subject, String object, String action){
        this.subject = getInstance(getSubjectClass(),subject);
        this.object = getInstance(getObjectClass(),object);
        this.action = getInstance(getActionClass(),action);
    }

    public PermRule(String subject, O object, String action){
        this.subject = getInstance(getSubjectClass(),subject);
        this.object = object;
        this.action = getInstance(getActionClass(),action);
    }

    public PermRule(S subject, O object, A action) {
        this.subject = subject;
        this.object = object;
        this.action = action;
    }

    public boolean matches(PermRule rule){
        return matches(rule,false);
    }

    public boolean matches(PermRule rule,boolean bothSides){
        return this.getSubject().matches(rule.getSubject(),bothSides) &&
                this.getAction().matches(rule.getAction(),bothSides) &&
                this.getObject().matches(rule.getObject(),bothSides);
    }

    protected Class<S> getSubjectClass() {
        return (Class<S>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Class<O> getObjectClass() {
        return (Class<O>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Class<A> getActionClass() {
        return (Class<A>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[2];
    }

    protected <X>  X  getInstance(Class<X> c, String... args)  {

        try {
            return c.getDeclaredConstructor(String.class).newInstance(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "PermRule{" +
                "subject=" + subject +
                ", object=" + object +
                ", action=" + action +
                '}';
    }
}
