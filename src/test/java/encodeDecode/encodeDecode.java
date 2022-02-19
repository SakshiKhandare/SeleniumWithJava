package encodeDecode;

import org.apache.commons.codec.binary.Base64;

public class encodeDecode {

	public static void main(String[] args) {

		String password = "demo123";
		System.out.println("original str---> "+password);
		
		byte[] encodePass  =Base64.encodeBase64(password.getBytes());	
		System.out.println("encoded str---> "+new String(encodePass));
		
		byte[] decodePass  =Base64.decodeBase64(encodePass);	
		System.out.println("decoded str---> "+new String(decodePass));
			
	}
}
