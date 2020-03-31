package np.com.ngopal.simpleperm.model;

import np.com.ngopal.model.core.BaseModel;
import np.com.ngopal.model.core.IBaseModel;
import np.com.ngopal.simpleperm.model.PermAction;
import np.com.ngopal.simpleperm.model.PermGeneric;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;



public interface PermGenericImpl<T extends PermGeneric>  extends PermGeneric<T>, IBaseModel<String> {

    default void setId(String id){
        this.setName(id);
    }

}
