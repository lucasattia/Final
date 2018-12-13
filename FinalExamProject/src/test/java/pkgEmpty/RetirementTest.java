package pkgEmpty;
import org.junit.Test;
import pkgCore.Retirement;
import junit.framework.TestCase;
public class RetirementTest extends TestCase {

	@Test
    public void testRetirement() {
    	Retirement r = new Retirement(40,0.07,20,0.02,10000,2642);
    	assert(r instanceof Retirement);
 	    assertEquals((double) r.MonthlySavings() == 554.13, true);
 	    assertEquals((double) r.TotalAmountToSave() == 1454485.55, true);
    }
}
