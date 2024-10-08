import java.math.BigInteger;

public class FlawedExample {

    public String findBitCount (BigInteger num) {
        int numInt = num.bitLength();
        return Integer.toHexString(numInt);
    }

    public void testBitCount () {
        BigInteger number = new BigInteger("1180590145325084590940239490622584768749437722435980772180699");

        String hexNum = findBitCount(number);
        System.out.println("Number of bits for N = " + hexNum);


    }
    public static void main (String[] args) {
		FlawedExample testObj = new FlawedExample ();

		System.out.println ("********** Project 2 output begins ********** ");

		testObj.testBitCount ();
		//testObj.testXgcd ();
	    //testObj.testKeygen ();
		//testObj.testRSA ();
	}
}