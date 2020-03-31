package np.com.ngopal.simpleperm.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PermObject<T extends PermObject> implements PermGeneric<T>{
    private String name;
    private T parent;

    public PermObject(String name, T parent) {
        this.name = name;
        this.parent = parent;
    }

    public PermObject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return toStr();
    }

}
