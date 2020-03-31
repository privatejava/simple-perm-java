package np.com.ngopal.simpleperm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermRuleComposite implements Serializable {

    private String subject;
    private String object;
    private String action;
}
