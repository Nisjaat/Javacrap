/*	Naam:		Nisjaat Sheik Joesoef
 *	Studentnr:	10219366
 *	Studie:		Informativa
 *	Login:		nisjaats
 *
 *	Dit programma bestaat uit 2 delen:
 *	1. Vraagt om een aantal(natuurlijk getal) en print de eerste aantal lucas-getallen
 *	   Wordt er een getal kleiner dan 0 ingevuld, dan wordt dat aangeven en vraagt of
 *	   je nogmaals een aantal wilt invoeren.
 *	2. Vraagt om integers(grondtal en exponent) en berekent de machtswaarde daaruit.
 *	   Is de grondtal 0 en de exponent 0 of kleiner dan 0, dan geeft het programma: 
 *	   Ongedefinieerd. Is de grondtal niet 0 maar de exponent wel, dan komt er 1.0 uit.
 *	   Vervolgens wordt er gevraagd of je nogmaals integers wilt invoeren.
 */


import java.util.*;

public class Opgave3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int hit = 0;
		String antwoord;
		while (hit == 0) {

			System.out.print("geef een natuurlijk getal: ");
			int lucasGetal = input.nextInt();
		
			if (lucasGetal >= 0) {
				lucasReeks(lucasGetal);		
				hit = 1;	
			}
			else {
				System.out.println("Dit is geen natuurlijk getal!\n");
				hit = 0;
			}

			System.out.print("Nogmaals [y/n]?");
			if (input.hasNext()) {
				antwoord = input.next();
				if (antwoord.toLowerCase().equals("y")) {
				hit = 0;
				} else {
					hit = 1;
				}
			}
		}

		System.out.println("We gaan nu machtsverheffen");
		
		int loop = 1;
		while (loop == 1){
			System.out.print("Geef een integer (het grondtal): " );
			int grondtal = input.nextInt() ;
			System.out.print("Geef nog een integer (de exponent): ");
			int exp = input.nextInt();
			macht(grondtal, exp);
			loop = 0;						

			
			System.out.print("Nogmaals [y/n]?");
			if (input.hasNext()) {
				antwoord = input.next();
				if (antwoord.toLowerCase().equals("y")) {
					loop = 1;
				} else {
					loop = 0;
				}
			}
		}
	}

	/* methode om lucas-getallen te berekenen.
	 * stopt bij de aangegeven aantal lucas-getallen.
         */ 
	static void lucasReeks(int aantal) {

		int getal1 = 2;
		int getal2 = 1;
		int getalTemp;

		System.out.print("De eerste "+aantal+" Lucas-getallen: ");
		while (aantal > 0) {
			System.out.print(+getal1+" ");
			getalTemp = getal1;
			getal2 = getal1 + getal2;
			getal1 = getal2 - getalTemp; 
			aantal = aantal - 1;
		}
		System.out.println();
	}
	
	/* Methode machtswaarde berekenen
	 * 
	 */
	static void macht(int grondtal, int exp) {

		double uitkomst = 1;
		int exponent = exp;

		while (exponent > 0) {
			uitkomst = uitkomst * grondtal;
			exponent = exponent - 1;
			
		}

		if (exponent < 0) {
			while (exponent < 0) {
				uitkomst = uitkomst * grondtal;
				exponent = exponent + 1;
			}
			uitkomst = 1 / uitkomst;
		}
		if (grondtal == 0 && exponent <= 0) {
			System.out.print("De uitkomst van "+grondtal);
			System.out.print(" tot-de-macht "+exp+" is: Ongedefinieerd\n");
		} else {
			System.out.print("De uitkomst van "+grondtal);
			System.out.print(" tot-de-macht "+exp+" is: "+uitkomst+"\n");
		}
	}
	
}
		
		
		
		
