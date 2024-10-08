import java.math.BigInteger;

public class FlawedExample {

    public String findBitCount (BigInteger num) {
        int numInt = num.bitLength();
        return Integer.toHexString(numInt);
    }

    public void testFlawedExample () {
        BigInteger number = new BigInteger("1180590145325084590940239490622584768749437722435980772180699");

        String hexNum = findBitCount(number);
        System.out.println("Number of bits for N = " + hexNum);

        BigInteger p = new BigInteger("967148115841218361396434822121");
        System.out.println("Number for P = " + p);

        BigInteger q = new BigInteger("1220692183532008344492309072419");
        String hexq = findBitCount(q);
        System.out.println("Number of bits for Q = " + hexq);

        BigInteger e = new BigInteger("65537");
        BigInteger z = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
        BigInteger d = e.modInverse(z);
        String hex_d = d.toString(16);
        System.out.println("d = " + hex_d);
        System.out.println("Number for Q = " + q);
        
        BigInteger m = new BigInteger("3");
        //Cypher Text = C
        BigInteger c = m.modPow(e, number);
        System.out.println("Cypher Text c = " + c);

        BigInteger decryptedM = c.modPow(d, number);
        System.out.println("Decrypted Message(3) = " + decryptedM);



        


    }

    public static void main (String[] args) {
		FlawedExample testObj = new FlawedExample ();

		System.out.println ("********** Project 2 output begins ********** ");

		testObj.testFlawedExample ();
	}
}