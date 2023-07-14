/**
 * 
 */
package currencyConvert.dataAccess;

import java.util.ArrayList;

/**
 * @author SS
 *
 */
public class Currency {
	/*
	 * Fields 
	 */
	private int id;
	private String name;
	private String code;
	private Character symbol;
	private ArrayList<CurrencyRate> rates;
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param code
	 * @param symbol
	 */
	public Currency(int id, String name, String code, Character symbol) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.symbol = symbol;
	}
	
    public double convertAmount(double amount, Currency targetCurrency) {
        CurrencyRate rate = findConversionRate(targetCurrency);
        return amount * rate.getRate();
    }

    public CurrencyRate findConversionRate(Currency targetCurrency) {
        for (CurrencyRate rate : rates) {
            if (rate.getTarget_currency_id() == targetCurrency.getId()) {
                return rate;
            }
        }
        throw new IllegalArgumentException("Conversion rate not found for target currency");
    }
    
	@Override
	public String toString() {
		return "Currency [id=" + id + ", name=" + name + ", code=" + code + ", symbol=" + symbol + "]";
	}
	
	/**
	 * @return the symbol
	 */
	public Character getSymbol() {
		return symbol;
	}
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(Character symbol) {
		this.symbol = symbol;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the rates
	 */
	public ArrayList<CurrencyRate> getRates() {
		return rates;
	}
	/**
	 * @param rates the rates to set
	 */
	public void setRates(ArrayList<CurrencyRate> rates) {
		this.rates = rates;
	}
}