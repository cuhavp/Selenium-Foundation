package modules;

import org.testng.annotations.*;

public class TestNgExample {

    @BeforeSuite
    void beforeSuite(){
        System.out.println("before suite");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("before Test");
    }
    @BeforeClass
    void beforeClass(){
        System.out.println("before class");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("before method");
    }


    @Test(groups = {"smoke-test"})
    void tc01(){
        System.out.println("tc01");
    }

    @Test
    void tc02(){
        System.out.println("tc02");
    }


    @Test(groups = {"smoke-test"})
    void tc03(){
        System.out.println("tc03");
    }
    @Test
    void tc04(){
        System.out.println("tc04");
    }
    @Test
    void tc05(){
        System.out.println("tc05");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("after method");
    }
    @AfterClass
    void afterClass(){
        System.out.println("after class");
    }
    @AfterTest
    void afterTest(){
        System.out.println("after test");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("after suite");
    }
}
