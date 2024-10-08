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

        BigInteger p = new BigInteger("967148115841218361396434822121");
        String hexp = findBitCount(p);
        System.out.println("Number of bits for P = " + hexp);

        BigInteger q = new BigInteger("1220692183532008344492309072419");
        String hexq = findBitCount(q);
        System.out.println("Number of bits for Q = " + hexq);



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