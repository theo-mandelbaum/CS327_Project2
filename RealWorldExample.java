import java.math.BigInteger;

public class RealWorldExample {
    
    public String findBitCount (BigInteger num) {
        int numInt = num.bitLength();
        return Integer.toHexString(numInt);
    }

    public void RealWorldTest(){

    }

    public static void main (String[] args) {
		RealWorldExample testObj = new RealWorldExample();

		System.out.println ("********** Project 2 output begins ********** ");

        testObj.RealWorldTest();
	}
}
