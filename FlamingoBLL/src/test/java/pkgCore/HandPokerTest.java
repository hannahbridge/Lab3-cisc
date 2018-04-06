package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest 
{

	@Test
	public void FourOfAKindTest1()
	{
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.FourOfAKind, HSP.geteHandStrength());
		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());
		assertEquals(1, HSP.getKickers().size());
		assertEquals(eRank.THREE, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
		
		assertEquals(hp.isFourOfAKind(),true);
		
		System.out.println("");
	}
	
	@Test
	public void FourOfAKindTest2() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.FourOfAKind, HSP.geteHandStrength());
		assertEquals(eRank.THREE, HSP.getHiCard().geteRank());
		assertEquals(1, HSP.getKickers().size());
		assertEquals(eRank.TWO, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
		
		assertEquals(hp.isFourOfAKind(),true);
		
		System.out.println("");

	}
		
	@Test
	public void ThreeOfAKindTest1() 
	{
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.THREE));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.ThreeOfAKind, HSP.geteHandStrength());
		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());
		assertEquals(2, HSP.getKickers().size());
		assertEquals(eRank.FIVE, HSP.getKickers().get(0).geteRank());
		assertEquals(eRank.THREE, HSP.getKickers().get(1).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
		assertEquals(eSuit.SPADES, HSP.getKickers().get(1).geteSuit());
		
		assertEquals(hp.isThreeOfAKind(),true);
		
		System.out.println("");
	}
	
	@Test
	public void ThreeOfAKindTest2() 
	{
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.SIX));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.ThreeOfAKind, HSP.geteHandStrength());
		assertEquals(eRank.SIX, HSP.getHiCard().geteRank());
		assertEquals(2, HSP.getKickers().size());
		assertEquals(eRank.FIVE, HSP.getKickers().get(0).geteRank());
		assertEquals(eRank.THREE, HSP.getKickers().get(1).geteRank());
		assertEquals(eSuit.SPADES, HSP.getKickers().get(0).geteSuit());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(1).geteSuit());
		
		assertEquals(hp.isThreeOfAKind(),true);
		
		System.out.println("");
	}
	
	@Test
	public void TwoPairTest1() 
	{
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.TwoPair, HSP.geteHandStrength());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertEquals(1, HSP.getKickers().size());
		assertEquals(eRank.THREE, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
		
		assertEquals(hp.isTwoPair(),true);
		
		System.out.println("");

	}
	
	@Test
	public void TwoPairTest2() 
	{
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.TwoPair, HSP.geteHandStrength());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertEquals(1, HSP.getKickers().size());
		assertEquals(eRank.THREE, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
		
		assertEquals(hp.isTwoPair(),true);
		
		System.out.println("");

	}
	
	@Test
	public void FullHouseTest1() 
	{
		System.out.println("Full House");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.FullHouse, HSP.geteHandStrength());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertEquals(0, HSP.getKickers().size());
		
		assertEquals(hp.isFullHouse(),true);
		
		System.out.println("");
	}
	
	@Test
	public void FullHouseTest2() {
		System.out.println("Full House");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.FullHouse, HSP.geteHandStrength());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertEquals(0, HSP.getKickers().size());
		
		assertEquals(hp.isFullHouse(),true);
		
		System.out.println("");
	}
		
	@Test
	public void PairTest1() 
	{
		System.out.println("Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.KING));
		hp.AddCard(new Card(eSuit.SPADES,eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.Pair, HSP.geteHandStrength());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertEquals(3, HSP.getKickers().size());
		assertEquals(eRank.KING, HSP.getKickers().get(0).geteRank());
		assertEquals(eRank.NINE, HSP.getKickers().get(1).geteRank());
		assertEquals(eRank.TWO, HSP.getKickers().get(2).geteRank());
		assertEquals(eSuit.DIAMONDS, HSP.getKickers().get(0).geteSuit());
		assertEquals(eSuit.SPADES, HSP.getKickers().get(1).geteSuit());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(2).geteSuit());
		
		assertEquals(hp.isPair(),true);
		
		System.out.println("");
	}
	
	@Test
	public void PairTest2() 
	{
		System.out.println("Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES,eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.KING));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.Pair, HSP.geteHandStrength());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertEquals(3, HSP.getKickers().size());
		assertEquals(eRank.KING, HSP.getKickers().get(0).geteRank());
		assertEquals(eRank.NINE, HSP.getKickers().get(1).geteRank());
		assertEquals(eRank.TWO, HSP.getKickers().get(2).geteRank());
		assertEquals(eSuit.DIAMONDS, HSP.getKickers().get(0).geteSuit());
		assertEquals(eSuit.SPADES, HSP.getKickers().get(1).geteSuit());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(2).geteSuit());
		
		assertEquals(hp.isPair(),true);
		
		System.out.println("");
	}
	
	@Test
	public void HighCardTest1() 
	{
		System.out.println("High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SIX));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.HighCard, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		
		assertEquals(hp.isHighCard(),true);
		
		System.out.println("");	

	}
	
	@Test
	public void HighCardTest2() 
	{
		System.out.println("High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.NINE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.SIX));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.HighCard, HSP.geteHandStrength());
		assertEquals(eRank.KING, HSP.getHiCard().geteRank());
		
		assertEquals(hp.isHighCard(),true);
		
		System.out.println("");
	}
	
	@Test
	public void StraightTest1() 
	{
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.Straight, HSP.geteHandStrength());
		assertEquals(eRank.SEVEN, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
		
		assertEquals(hp.isStraight(),true);
		
		System.out.println("");

	}
	
	@Test
	public void StraightTest2() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.Straight, HSP.geteHandStrength());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
		
		assertEquals(hp.isStraight(),true);
		
		System.out.println("");

	}
	
	@Test
	public void StraightTest3() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.SPADES, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.Straight, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
		
		assertEquals(hp.isStraight(),true);
		
		System.out.println("");

	}	
	
	@Test
	public void FlushTest1() 
	{
		System.out.println("Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.ACE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.SEVEN));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.SIX));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.JACK));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.Flush, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void FlushTest2() 
	{
		System.out.println("Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.SEVEN));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.NINE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.QUEEN));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.Flush, HSP.geteHandStrength());
		assertEquals(eRank.QUEEN, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
		
		assertEquals(hp.isFlush(),true);
		
		System.out.println("");
	}
	
	@Test
	public void StraightFlushTest1() 
	{
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.SIX));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.SEVEN));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.EIGHT));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.NINE));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(hp.isStraightFlush(),true);
		assertEquals(eHandStrength.StraightFlush, HSP.geteHandStrength());
		assertEquals(eRank.NINE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void StraightFlushTest2() 
	{
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.SIX));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.NINE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.EIGHT));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.SEVEN));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(hp.isStraightFlush(),true);
		assertEquals(eHandStrength.StraightFlush, HSP.geteHandStrength());
		assertEquals(eRank.NINE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void RoyalFlushTest1() 
	{
		System.out.println("Royal Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TEN));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.JACK));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.QUEEN));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.KING));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.ACE));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(hp.isRoyalFlush(),true);
		assertEquals(eHandStrength.RoyalFlush, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void RoyalFlushTest2() 
	{
		System.out.println("Royal Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.KING));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.ACE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.JACK));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TEN));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.QUEEN));
		try 
		{
			hp.ScoreHand();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(hp.isRoyalFlush(),true);
		assertEquals(eHandStrength.RoyalFlush, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}

}