package np.com.ngopal.simpleperm.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "PERM_SUBJECT")
@NoArgsConstructor
public class PermSubjectImpl extends PermSubject<PermSubjectImpl> implements PermGenericImpl<PermSubjectImpl> {

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

    public PermSubjectImpl(String name, PermSubjectImpl parent) {
        super(name, parent);
    }

    public PermSubjectImpl(String name) {
        super(name);
    }

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "PARENT_ID")
    @Override
    public PermSubjectImpl getParent() {
        return super.getParent();
    }


    @Override
    public void setParent(PermSubjectImpl parent) {
        super.setParent(parent);
    }



}
