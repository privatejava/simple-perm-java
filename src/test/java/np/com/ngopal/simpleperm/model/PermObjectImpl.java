package np.com.ngopal.simpleperm.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "PERM_OBJECT")
@NoArgsConstructor
public class PermObjectImpl  extends PermObject<PermObjectImpl> implements PermGenericImpl<PermObjectImpl> {


    public PermObjectImpl(String name, PermObjectImpl parent) {
        super(name, parent);
    }

    public PermObjectImpl(String name) {
        super(name);
    }

    @Override
    @Id
    @XmlAttribute
    @Basic(optional = false)
    @Access(AccessType.PROPERTY)
    @Column(name = "ID", nullable = false)
    public String getId() {
        return this.getName();
    }

    public void setId(String id){
        this.setName(id);
    }

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "PARENT_ID")
    @Override
    public PermObjectImpl getParent() {
        return super.getParent();
    }

    @Override
    public void setParent(PermObjectImpl parent) {
        super.setParent(parent);
    }
}
