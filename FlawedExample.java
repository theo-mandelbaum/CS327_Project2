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
        String p_hex = p.toString(16);
        String bits_p = findBitCount(p);
        System.out.println("P = " + p_hex);
        System.out.println("Number of bits for P = " + bits_p);

        BigInteger q = new BigInteger("1220692183532008344492309072419");
        String q_hex = q.toString(16);
        String bits_q = findBitCount(q);
        System.out.println("Q = " + q_hex);
        System.out.println("Number of bits for Q = " + bits_q);

        BigInteger e = new BigInteger("65537");
        // z = (p - 1) * (q-1)
        BigInteger z = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
        BigInteger d = e.modInverse(z);
        String hex_d = d.toString(16);
        System.out.println("d = " + hex_d);
        
        BigInteger m = new BigInteger("3");
        // Cypher Text = C
        // c = m^e mod N
        BigInteger c = m.modPow(e, number);
        String c_hex = c.toString(16);
        System.out.println("Cypher Text c = " + c_hex);

        // decrypt by solving m' = c^d mod N
        BigInteger decryptedM = c.modPow(d, number);
        String decryptedM_hex = decryptedM.toString(16);
        // When the message (m = 3) is decrypted, the result is printed
        System.out.println("Decrypted Message(3) = " + decryptedM_hex);



        


    }

    public static void main (String[] args) {
		FlawedExample testObj = new FlawedExample ();

		System.out.println ("********** Project 2 output begins ********** ");

		testObj.testFlawedExample ();
	}
}