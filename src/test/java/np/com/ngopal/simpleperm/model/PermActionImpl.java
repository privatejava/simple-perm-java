package np.com.ngopal.simpleperm.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "PERM_ACTION")
@NoArgsConstructor
public class PermActionImpl extends PermAction<PermActionImpl> implements PermGenericImpl<PermActionImpl> {

    @Override
    @Id
    @XmlAttribute
    @Basic(optional = false)
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
    public PermActionImpl getParent() {
        return super.getParent();
    }

    @Override
    public void setParent(PermActionImpl parent) {
        super.setParent(parent);
    }

    public PermActionImpl(String name, PermActionImpl parent) {
        super(name, parent);
    }

    public PermActionImpl(String name) {
        super(name);
    }
}
