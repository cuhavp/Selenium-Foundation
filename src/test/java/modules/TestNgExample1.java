package modules;

import org.testng.annotations.*;

public class TestNgExample1 {
    @BeforeSuite
    void beforeSuite(){
        System.out.println("1- before suite");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("1-before Test");
    }
    @BeforeClass
    void beforeClass(){
        System.out.println("1-before class");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("1-before method");
    }
    @Test
    void tc01(){
        System.out.println("1-tc01");
    }
    @Test
    void tc02(){
        System.out.println("1-tc02");
    }
    @Test
    void tc03(){
        System.out.println("1-tc03");
    }
    @Test
    void tc04(){
        System.out.println("1-tc04");
    }
    @Test
    void tc05(){
        System.out.println("1-tc05");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("1-after method");
    }
    @AfterClass
    void afterClass(){
        System.out.println("1-after class");
    }
    @AfterTest
    void afterTest(){
        System.out.println("1-after test");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("1-after suite");
    }
}
