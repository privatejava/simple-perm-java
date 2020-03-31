package np.com.ngopal.simpleperm.db;


import np.com.ngopal.simpleperm.model.PermAction;

public class PermJPAImpl extends PermAction {

    public PermJPAImpl(String name, PermAction parent) {
        super(name, parent);
    }
}
