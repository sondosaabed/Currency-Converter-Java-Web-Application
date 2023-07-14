/*
 * 
 */
package currencyConvert.dataAccess;

/**
 * @author SS
 *
 */
public class CurrencyRate {
	/*
	 * Fields
	 */
	private int id;
	private int source_currency_id;
	private int target_currency_id;
	private double rate;
	
	/**
	 * @param id
	 * @param source_currency_id
	 * @param target_currency_id
	 * @param rate
	 */
	public CurrencyRate(int id, int source_currency_id, int target_currency_id, double rate) {
		super();
		this.id = id;
		this.source_currency_id = source_currency_id;
		this.target_currency_id = target_currency_id;
		this.rate = rate;
	}
	
    public CurrencyRate(int source_currency_id, int target_currency_id, double rate) {
        this.source_currency_id = source_currency_id;
        this.target_currency_id = target_currency_id;
        this.rate = rate;
    }

	@Override
	public String toString() {
		return "CurrencyRate [id=" + id + ", source_currency_id=" + source_currency_id + ", target_currency_id="
				+ target_currency_id + ", rate=" + rate + "]";
	}

	/**
	 * @return the source_currency_id
	 */
	public int getSource_currency_id() {
		return source_currency_id;
	}
	/**
	 * @param source_currency_id the source_currency_id to set
	 */
	public void setSource_currency_id(int source_currency_id) {
		this.source_currency_id = source_currency_id;
	}
	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
	/**
	 * @return the target_currency_id
	 */
	public int getTarget_currency_id() {
		return target_currency_id;
	}
	/**
	 * @param target_currency_id the target_currency_id to set
	 */
	public void setTarget_currency_id(int target_currency_id) {
		this.target_currency_id = target_currency_id;
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
}