package pl.kamski;

import org.junit.jupiter.api.Test;

public class FirstTest {

    @Test
    void myFirstTest() {
        assert true == true;
    }

    @Test
    void my2ndTest() {
        String name = "filip";
        String hello = String.format("Hello %s", name);
        assert hello.equals("Hello filip");
    }

    @Test
    void baseTestSchema() {
        //Arrange   //Given     //Input
        //Act       //When      //Call/interaction
        //Assert    //Then      //Output
    }

}
