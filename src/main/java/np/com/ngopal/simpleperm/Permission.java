package np.com.ngopal.simpleperm;

import np.com.ngopal.simpleperm.model.PermRule;

import java.util.List;

public class Permission {
    private List<PermRule> rules;

    public boolean matches(PermRule rule){
        for(PermRule r: rules){
            if(r.getObject().getName().equalsIgnoreCase(rule.getObject().getName())){
                return true;
            }
        }
        return false;
    }
}
