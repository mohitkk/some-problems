package inheritanceTesting;

import java.util.HashMap;
import java.util.Map;

public class MainTestClass {
    public static void main(final String args[]) {
        final Map<String, TestOne> map = new HashMap<String, TestOne>();
        final TestClassOne obj1 = new TestClassOne();
        final TestClassOne obj2 = new TestClassOne();
        final TestClassOne obj3 = new TestClassOne();
        final TestClassOne obj4 = new TestClassOne();
        map.put("one", obj1);
        map.put("two", obj2);
        map.put("three", obj3);
        map.put("four", obj4);

        final MainTestClass obj = new MainTestClass();
        obj.test(map);
    }

    public void test(final Map<String, TestOne> map) {

    }
}
