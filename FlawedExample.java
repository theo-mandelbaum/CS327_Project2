import java.math.BigInteger;

public class FlawedExample {

    public int findBitCount (BigInteger num) {
        return num.bitLength();
    }

    public void testBitCount () {
        BigInteger number = new BigInteger("1180590145325084590940239490622584768749437722435980772180699");

        System.out.println("The number of bits in 1180590145325084590940239490622584768749437722435980772180699 is:" + findBitCount(number));


    }
    public static void main (String[] args) {
		FlawedExample testObj = new FlawedExample ();

		System.out.println ("********** Project 2 output begins ********** ");

		//testObj.testGcd ();
		//testObj.testXgcd ();
	    //testObj.testKeygen ();
		//testObj.testRSA ();
	}
}