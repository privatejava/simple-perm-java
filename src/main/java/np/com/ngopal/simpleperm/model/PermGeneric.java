package np.com.ngopal.simpleperm.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

//@Slf4j
//@Getter
//@Setter
public interface PermGeneric<T extends PermGeneric> extends Serializable {
    Logger log = LoggerFactory.getLogger(PermGeneric.class);
    public static String ANY = "*";

    //    protected String name;
//    protected T parent;
    T getParent();

    String getName();

    void setName(String name);

//    public PermGeneric(String name, T parent) {
//        this.name = name;
//        this.parent = parent;
//    }
//
//    public PermGeneric(String name) {
//        this.name = name;
//    }

    default boolean hasParent() {
        return this.getParent() != null;
    }


    void setParent(T data);

    default int getLevels() {
        int i = 0;
        T t = this.getParent();
        while (t != null) {
            i++;
            t = (T) t.getParent();
        }
        return i;
    }

    default boolean matches(T perm) {
        return matches(perm, false);
    }

    default boolean matches(T perm, boolean bothSide) {
        log.debug("Match: {}, {}", this, perm);
        if ((perm.getName().equalsIgnoreCase(this.getName()) && perm.getLevels() <= this.getLevels()) ||
                (perm.getName().equalsIgnoreCase("*")) && perm.getLevels() <= this.getLevels()
        ) {
            return true;
        }
        //Againt (this) object

        if (bothSide && this.hasParent()) {
            return this.getParent().matches(perm, bothSide);
        }


        if (perm.hasParent()) {
            return matches((T) perm.getParent(), bothSide);
        }
        return false;
    }


    default String toStr() {
        return hasParent() ? getParent() + "." + getName() : getName();
    }
}
