package np.com.ngopal.simpleperm;

import lombok.extern.slf4j.Slf4j;
import np.com.ngopal.simpleperm.db.*;
import np.com.ngopal.simpleperm.model.*;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class PersistTest {

    TestModelService service;

    @BeforeClass
    public static void setup() throws IOException {
        File f = new File("target/classes/META-INF");
        f.mkdirs();
        Files.copy(new File("target/test-classes/META-INF/persistence.xml").toPath(), new File("target/classes/META-INF/persistence.xml").toPath(),StandardCopyOption.REPLACE_EXISTING);
//        FileUtils.copyDirectory(new File("target/test-classes/np/com/ngopal/simpleperm"),new File("target/classes/np/com/ngopal/simpleperm"));
    }

    @Before
    public void prepare(){
//        service = new TestModelService();
    }


    @Test
    public void testPersist(){
        PermActionService actionService = new PermActionService();
        PermSubjectService subService = new PermSubjectService();
        PermObjectService objService = new PermObjectService();
        PermRuleService ruleService = new PermRuleService();

        PermSubjectImpl sub= new PermSubjectImpl("john");
        PermActionImpl read = new PermActionImpl("read");
        PermActionImpl deptRead = new PermActionImpl("deptRead",read);
        subService.save(sub);
        actionService.save(read);
        actionService.save(deptRead);

        PermObjectImpl user = new PermObjectImpl("user");
        PermObjectImpl dept = new PermObjectImpl("account",user);
        objService.save(user);
        objService.save(dept);

        PermRuleImpl rule = new PermRuleImpl(sub,dept,deptRead);
        PermRuleImpl rule2 = new PermRuleImpl("john","user","read");
        ruleService.save(rule);


        List<PermRuleImpl> johnRole = ruleService.getRulesBySubject("john");

        assertEquals(1,johnRole.size());
        assertEquals(johnRole.get(0).getAction(),rule.getAction());
        assertEquals(johnRole.get(0).getSubject(),rule.getSubject());
        assertEquals(johnRole.get(0).getObject(),rule.getObject());

        rule = johnRole.get(0);

        log.debug("Rule check: {} <> {}", rule, rule2);
        assertTrue(rule2.matches(rule));
//
        log.debug("Rule check: {} <> {}", rule2, rule);
        assertFalse(rule.matches(rule2));
//
        assertTrue(rule.matches(rule2,true));
        assertTrue(rule.matches(rule2,true));
    }

    @Test
    public void testPersist2(){
        TestModel impl = new TestModel(2L);
        service.save(impl);
    }
}
