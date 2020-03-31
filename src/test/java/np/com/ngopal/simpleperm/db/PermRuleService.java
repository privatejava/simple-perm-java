package np.com.ngopal.simpleperm.db;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import np.com.ngopal.services.core.AbstractService;
import np.com.ngopal.simpleperm.model.*;

import java.util.List;

public class PermRuleService extends AbstractService<PermRuleImpl, PermRuleComposite> {
    public List<PermRuleImpl> getRulesBySubject(String subject){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QPermRuleImpl rule = QPermRuleImpl.permRuleImpl;
        JPQLQuery<PermRuleImpl> all = query.selectFrom(rule).where(rule.subject.id.eq(subject)).distinct();
        return all.fetch();
    }
}
