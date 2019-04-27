package examples;

import java.util.StringTokenizer;

public class StringDemo {
	public static void main(String[] args) {
		String input = "I have a crush on her. But I'm about to leave. What should I suppose to say to her about my feeling?\r\n" + 
				"She is the one who's working on 12th floor, and I'm studying on this floor, as well. But tomorrow I have to leave this place and return to my department (mobile solution) in 7th floor for studying, because my Android course has finished. Remember I'm here only for studying Android.\r\n" + 
				"So tomorrow I have to leave and never come back this place again, except I have something to do on this floor! How do I have a chance to meet her again??? How do I say something to her??\r\n" + 
				"That's suck!!!";
//		String reverseInput = "?gnileef ym tuoba reh ot yas ot esoppus I dluohs tahW .evael ot tuoba m'I tuB .reh no hsurc a evah I\r\n" + 
//				".diordnA gniyduts rof ylno ereh m'I rebmemeR .dehsinif sah esruoc diordnA ym esuaceb ,gniyduts rof roolf ht7 ni )noitulos elibom( tnemtraped ym ot nruter dna ecalp siht evael ot evah I worromot tuB .llew sa ,roolf siht no gniyduts m'I dna ,roolf ht21 no gnikrow s'ohw eno eht si ehS\r\n" + 
//				"??reh ot gnihtemos yas I od woH ???niaga reh teem ot ecnahc a evah I od woH !roolf siht no od ot gnihtemos evah I tpecxe ,niaga ecalp siht kcab emoc reven dna evael ot evah I worromot oS\r\n" + 
//				"!!!kcus s'tahT";
		//System.out.println(input);
		
		StringTokenizer tokenizer = new StringTokenizer(input, "\r\n");
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			char [] ch = token.toCharArray();
			for(int i=ch.length-1; i>=0; i--) {
				System.out.print(ch[i]);
			}
			System.out.println();
		}
		
		
	}
}
