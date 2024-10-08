import java.math.BigInteger;

public class RealWorldExample {
    
    public int findBitCount (BigInteger num) {
        return num.bitLength();
    }

    public void RealWorldTest(){
        BigInteger P = new BigInteger("bdf78a7a486847dc2fc6cccf45161dad36641ce09a1907ff5c5c088d3f9011135d0b77a75faabc6ff9d42499f9949b61ca5e32b5458b5240e2aafb18d9486bddbb80014b1f8945947eaafe6964a3ea96f345b2f0a93e7db100ab21c7b38d2e0d19fddfe8b8fcf8f593aae667edc15e76d9af847886e2db47a4b53243950eed016439c5874b5de2aba1065faeefdf1d9756ac8bc453b379ae18a85f3e911205b841f8da08ab52963b34661150938c2de16bf910a497049352422873a75531ca59",16);
        BigInteger Q = new BigInteger("ff8b62ff55f9f7a5a279db0960921f1b9f04172996867293b3987b1ad49160a2539156bc2c56489a046ede63b34c91ac5fe897d7865c0b62c7eed50c71e62163a6f9795653c6c4e1ad69477739f92b39bb8b9c99d0c780b641abccb307f405f141668847c25fcf2305e62902e6e5325bace643097581bd14f36008c0c8b33e27d06615728dcaa293f18c6a350ab3b7f634a66a097ecedaac8421ca24f24123236f57b4f520739d949594bd6efb029609282c9e87622b0a16514789001df5f545",16);
        
        BigInteger E = ((new BigInteger("2").pow(16)).add(new BigInteger("1")));
        BigInteger N = P.multiply(Q);
        System.out.println("Bob's Public Key is (" + N + ", " + E + ")");
        /*System.out.println("N: "+ N.toString(16));
        System.out.println("E: "+ E.toString(16));*/

        System.out.println();
        
        int numBitsN = findBitCount(N);
        System.out.println("Number of bits for N: "+ numBitsN);
        int numBitsP = findBitCount(P);
        System.out.println("Number of bits for P: "+ numBitsP);
        int numBitsQ = findBitCount(Q);
        System.out.println("Number of bits for Q: "+ numBitsQ);
        System.out.println();


        BigInteger z = P.subtract(new BigInteger("1")).multiply(Q.subtract(new BigInteger("1")));
        BigInteger d = E.modInverse(z);
        String hex_d = d.toString(16);
        System.out.println("Bob's private key (d) = 0x" + hex_d);
        System.out.println();

        // To perform plain RSA ecryption, Alice will compute a ciphertext using c = m^e mod N
        BigInteger m = new BigInteger("3");
        // Cypher Text = C
        // c = m^e mod N
        BigInteger c = m.modPow(E, N);
        String c_hex = c.toString(16);
        System.out.println("Cypher Text c = 0x" + c_hex);
        System.out.println();

        // In order for Bob to decrypt the ciphertext from above, he must compute m' = c^d mod N
        BigInteger decryptedM = new BigInteger("0");
        long begin = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++) {
            decryptedM = c.modPow(d, N);
        }
        long end = System.currentTimeMillis();

        BigInteger beginBig = BigInteger.valueOf(begin);
        BigInteger endBig = BigInteger.valueOf(end);

        BigInteger totalTimeMilliSec = endBig.subtract(beginBig);
        BigInteger totalTimeSec = totalTimeMilliSec.divide(BigInteger.valueOf(1000));
        float avgTime = totalTimeSec.floatValue() / 1000;
        float bps = findBitCount(N) / avgTime;

        System.out.println("Average bps = " + bps);
        System.out.println("Average kbps = " + bps / 1000);

        String decryptedM_hex = decryptedM.toString(16);
        // When the message (m = 3) is decrypted, the result is printed
        System.out.println("Decrypted Message(3) = 0x" + decryptedM_hex);
        System.out.println();


    }

    public static void main (String[] args) {
		RealWorldExample testObj = new RealWorldExample();

		System.out.println ("********** Project 2 output begins ********** ");
        System.out.println();

        testObj.RealWorldTest();
	}
}
