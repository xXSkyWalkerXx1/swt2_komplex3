import junit.framework.Assert;
import org.junit.jupiter.api.*;


public class SimpleLinkedListTest {

    static SimpleLinkedList<Integer> linkedList;
    static int[] dummyValues = new int[]{0,1,2};

    /***
     * Static method to setup once everything we need for all testcases.
     */
    @BeforeAll
    static void setUp(){
        // Initialize all attributes
        linkedList = new SimpleLinkedList<>();

        // Add some dummy elements
        for (int element : dummyValues){
            linkedList.add(element);
        }
    }

    /***
     * Check, that the created instance (see setUp()) is not null.
     * (dummy testcase as first try)
     */
    @Test
    void isNotNull(){
        Assert.assertNotNull(linkedList);
    }

    /***
     * Check for equivalence of dummy instance size and the predicted size.
     */
    @Test
    void getSize(){
        Assert.assertEquals(3, linkedList.size());
    }

    /***
     * Check, whether we can iterate throught the instance.
     * This case is used to determinate any exceptions, like NullPointerException and so on.
     */
    @Test
    void verifyListStructure(){
        int i = 0;

        for (Integer element : linkedList){
            Assert.assertEquals(dummyValues[i], element.intValue());
            i++;
        }
    }
}
