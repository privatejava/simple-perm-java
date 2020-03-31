package np.com.ngopal.simpleperm.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PermSubject<T extends PermSubject> implements PermGeneric<T>{

    private String name;

    private T parent;

    public PermSubject(String name, T parent) {
        this.name = name;
        this.parent = parent;
    }

    public PermSubject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return toStr();
    }
}
