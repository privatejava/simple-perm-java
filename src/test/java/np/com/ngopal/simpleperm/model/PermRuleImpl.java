package np.com.ngopal.simpleperm.model;

import lombok.NoArgsConstructor;
import np.com.ngopal.model.core.IBaseModel;

import javax.persistence.*;
import javax.security.auth.Subject;
import javax.swing.*;

@Entity
@Table(name = "PERM_RULE")
@NoArgsConstructor
@IdClass(PermRuleComposite.class)
public class PermRuleImpl extends PermRule<PermSubjectImpl,PermObjectImpl,PermActionImpl> implements IBaseModel<PermRuleComposite> {
    public PermRuleImpl(String subject, String object, String action) {
        super(subject, object, action);
    }

    public PermRuleImpl(String subject, PermObjectImpl object, String action) {
        super(subject, object, action);
    }

    public PermRuleImpl(PermSubjectImpl subject, PermObjectImpl object, PermActionImpl action) {
        super(subject, object, action);
    }

    @Id
    @Override
    public PermSubjectImpl getSubject() {
        return super.getSubject();
    }

    @Id
    @Override
    public PermObjectImpl getObject() {
        return super.getObject();
    }

    @Id
    @Override
    public PermActionImpl getAction() {
        return super.getAction();
    }

    @Override
    public void setSubject(PermSubjectImpl subject) {
        super.setSubject(subject);
    }

    @Override
    public void setObject(PermObjectImpl object) {
        super.setObject(object);
    }

    @Override
    public void setAction(PermActionImpl action) {
        super.setAction(action);
    }

    @Override
    @Transient
    public PermRuleComposite getId() {
        return new PermRuleComposite(getSubject().getName(),getObject().getName(),getAction().getName());
    }

    @Override
    public void setId(PermRuleComposite id) {

    }
}
