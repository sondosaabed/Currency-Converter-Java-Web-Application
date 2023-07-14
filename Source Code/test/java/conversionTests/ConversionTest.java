package conversionTests;
import currencyConvert.dataAccess.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ConversionTest {
    private Currency baseCurrency;
    private Currency targetCurrency;
    
    @BeforeEach
    public void setup() {
        // Create test instances of base currency and target currency
        // Pass the necessary parameters to the constructor
        baseCurrency = new Currency(1, "USD", "USD", '$');
        targetCurrency = new Currency(2, "EUR", "EUR", '€');
        
        // Create test rates
        ArrayList<CurrencyRate> rates = new ArrayList<>();
        rates.add(new CurrencyRate(1, 1, 2, 0.85)); // USD to EUR rate
        
        // Set the rates in the base currency
        baseCurrency.setRates(rates);
    }
    
    @Test
    public void testConvertAmount() {
        double amount = 100.0;
        
        // Calculate the expected result based on the rate
        double expected = amount * 0.85;
        
        // Perform the conversion
        double actual = baseCurrency.convertAmount(amount, targetCurrency);
        
        // Assert the result
        assertEquals(expected, actual, 0.001); // Adjust the delta value based on your desired precision
    }
    
    @Test
    public void testFindConversionRate() {
        // Call the method under test
        CurrencyRate rate = baseCurrency.findConversionRate(targetCurrency);
        
        // Assert the result
        assertNotNull(rate); // Assert that a rate is found
        assertEquals(0.85, rate.getRate(), 0.001); // Assert that the rate value matches the expected value
    }
    
    @Test
    public void testFindConversionRate_ThrowsException() {
        // Create a non-existing test target currency
        Currency nonExistingCurrency = new Currency(3, "GBP", "GBP", '£');
        
        // Call the method under test and assert that it throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            baseCurrency.findConversionRate(nonExistingCurrency);
        });
    }
}
