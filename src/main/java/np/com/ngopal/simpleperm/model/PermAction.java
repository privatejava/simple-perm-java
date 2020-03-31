package np.com.ngopal.simpleperm.model;


import lombok.*;


@EqualsAndHashCode
@Getter
@Setter
public class PermAction<T extends PermAction> implements PermGeneric<T>{

    protected String name;

    protected T parent;

    public PermAction() {
    }


    public PermAction(String name, T parent) {
        this.name = name;
        this.parent = parent;
    }

    public PermAction(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return toStr();
    }
}
