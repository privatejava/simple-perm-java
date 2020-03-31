package np.com.ngopal.simpleperm.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import np.com.ngopal.model.core.BaseModel;

import javax.persistence.Entity;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TestModel extends BaseModel<Long> {

    private String name;

    public TestModel(Long data) {
        setId(data);
    }
}
