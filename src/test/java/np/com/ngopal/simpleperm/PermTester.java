package np.com.ngopal.simpleperm;

import lombok.extern.slf4j.Slf4j;
import np.com.ngopal.simpleperm.model.PermAction;
import np.com.ngopal.simpleperm.model.PermObject;
import np.com.ngopal.simpleperm.model.PermRule;
import np.com.ngopal.simpleperm.model.PermSubject;
import static org.junit.Assert.*;
import org.junit.Test;

@Slf4j
public class PermTester {
    @Test
    public void checkLevel(){
        PermAction action= new PermAction("Read");
        PermAction action2= new PermAction("ReadDept",action);
        PermAction action3= new PermAction("ReadDeptAccount",action2);
        assertEquals(0,action.getLevels());
        assertEquals( 1,action2.getLevels());
        assertEquals( 2,action3.getLevels());
    }

    @Test
    public void test1(){
        PermSubject sub= new PermSubject("john");
        PermAction read = new PermAction("read");
        PermAction deptRead = new PermAction("deptRead",read);

        PermObject user = new PermObject("user");
        PermObject dept = new PermObject("account",user);
        PermRule rule = new PermRule(sub,dept,deptRead);
        PermRule rule2 = new PermRule("john","user","read");

        log.debug("Rule check: {} <> {}", rule, rule2);
        assertTrue(rule2.matches(rule));

        log.debug("Rule check: {} <> {}", rule2, rule);
        assertFalse(rule.matches(rule2));

        assertTrue(rule.matches(rule2,true));
        assertTrue(rule.matches(rule2,true));

    }
}
